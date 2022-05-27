package service;

import model.Animal;
import model.Bug;
import model.Fish;
import model.Sea;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserInteractionTest {

    UserInteractionMock userInteractionMock = new UserInteractionMock();
    UserInteraction userInteraction;
    ByteArrayOutputStream outputStream;

    InformationService informationService;
    UserService userService = new UserService();
    String userName;
    Animal hardcodedAnimal;
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();

    @BeforeEach
    void setUp() {
        userInteraction = new UserInteraction();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        informationService = new InformationService();
        userName = userInteractionMock.getUserInputForUserCreation();
        hardcodedAnimal = new Animal(animalFish, animalBug, animalSea);
    }

    @Test
    void showFirstMessage() {
        userInteraction.showFirstMessage();
        assertTrue(outputStream.toString().contains("Willkommen zum Animal Crossing: New Horizons Hilfsprogramm"));
    }

    @org.junit.Test
    public void getUserInputForCatchableAnimals() {
        assertArrayEquals(new int[] {1, 5, 20}, userInteractionMock.getUserInputForCatchableAnimals());
    }

    @org.junit.Test
    public void getUserInputForUserCreation() {
        assertEquals("Testnutzer", userInteractionMock.getUserInputForUserCreation());
    }

    @org.junit.Test
    public void getUserInputForInventory() {
        assertEquals("Bitterling", userInteractionMock.getUserInputForInventory());
    }

    @org.junit.Test
    public void getNextAction() throws FileNotFoundException {
    }
}