package repository;

import model.Animal;
import model.Bug;
import model.Fish;
import model.Sea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.InformationService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalRepositoryTest {

    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();
    private Animal testHardcodedAnimal;
    private Animal hardcodedAnimal;

    @BeforeEach
    void setUp() {
        testHardcodedAnimal = new Animal(animalFish, animalBug, animalSea);
        AnimalRepository testRepository = new AnimalRepository();
        hardcodedAnimal = testRepository.createHardcodedAnimal();
    }

    @Test
    void testCreateHardcodedAnimal() {
        assertNotNull(hardcodedAnimal);
        assertInstanceOf(testHardcodedAnimal.getClass(), hardcodedAnimal);
    }
}