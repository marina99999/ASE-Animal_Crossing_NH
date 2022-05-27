package service;

import model.Animal;
import model.Bug;
import model.Fish;
import model.Sea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AnimalRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InformationServiceTest {

    private Animal hardcodedAnimal;
    private InformationService informationService;
    private int[] userInput = {1, 4, 4};

    @BeforeEach
    void setUp() {
        AnimalRepository testRepository = new AnimalRepository();
        hardcodedAnimal = testRepository.createHardcodedAnimal();
        informationService = new InformationService();
    }

    @Test
    void getCatchableAnimals() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        informationService.getCatchableAnimals(userInput, hardcodedAnimal);

        assertTrue(outputStream.toString().contains("Fangbare Fische:"));
        assertTrue(outputStream.toString().contains("|   Id|           Name|     Größe|       Ort|Preis|"));

        assertTrue(outputStream.toString().contains("Fangbare Meerestiere:"));
        assertTrue(outputStream.toString().contains("|   Id|                Name|     Größe|Geschwindigkeit|Preis|"));
        assertTrue(outputStream.toString().contains("|    1|         Wakame-Alge|      groß|   stillstehend|  600|"));


        assertTrue(outputStream.toString().contains("Fangbare Insekten:"));
        assertTrue(outputStream.toString().contains("|   Id|           Name|       Ort|Preis|"));
        assertTrue(outputStream.toString().contains("|    1|   Kohlweißling|  fliegend|  160|"));
        assertTrue(outputStream.toString().contains("|    2| Zitronenfalter|  fliegend|  160|"));
    }
}