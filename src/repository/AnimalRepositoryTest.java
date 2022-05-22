package repository;

import model.Animal;
import model.Bug;
import model.Fish;
import model.Sea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryTest {

    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();

    @Test
    void testCreateHardcodedAnimal() {
        Animal testHardcodedAnimal = new Animal(animalFish, animalBug, animalSea);
        AnimalRepository testRepository = new AnimalRepository();
        Animal hardcodedAnimal = testRepository.createHardcodedAnimal();

        assertNotNull(hardcodedAnimal);
        assertInstanceOf(testHardcodedAnimal.getClass(), hardcodedAnimal);
    }
}