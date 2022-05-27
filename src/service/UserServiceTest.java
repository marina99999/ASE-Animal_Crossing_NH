package service;

import model.Animal;
import model.Bug;
import model.Fish;
import model.Sea;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    UserServiceMock userServiceMock = new UserServiceMock();
    UserService userService = new UserService();
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();
    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfAnimalExists() {
        assertTrue(userServiceMock.checkIfAnimalExists(new Animal(animalFish, animalBug, animalSea), "Testanimal"));
    }

    @Test
    public void checkIfAnimalExistsInInventory() {
        assertTrue(userServiceMock.checkIfAnimalExistsInInventory("Testuser", "Testanimal"));
    }

    @Test
    public void OutputAllAnimalsOfInventory() throws FileNotFoundException {
        userServiceMock.OutputAllAnimalsOfInventory("Testuser");
        assertTrue(outputStream.toString().contains("Testoutput"));
    }
}