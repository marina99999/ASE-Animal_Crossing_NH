package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BugTest {

    private Animal testAnimal;
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();
    Bug testBug = new Bug(1, "Test-Insekt", "fliegend", 160, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5, 6}, new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12});

    @BeforeEach
    void setUp() {
        animalBug.add(testBug);

        testAnimal = new Animal(animalFish, animalBug, animalSea);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCatchableBug() {
        assertEquals(1, testAnimal.getAnimalBug().get(0).getCatchableBug(new int[]{1, 12, 12}, testAnimal).size());
        assertTrue(testAnimal.getAnimalBug().get(0).getCatchableBug(new int[]{1, 12, 12}, testAnimal).contains(testBug));
    }

    @Test
    void getBugId() {
        assertEquals(1, testAnimal.getAnimalBug().get(0).getBugId());
    }

    @Test
    void getName() {
        assertEquals("Test-Insekt", testAnimal.getAnimalBug().get(0).getName());
    }

    @Test
    void getLocation() {
        assertEquals("fliegend", testAnimal.getAnimalBug().get(0).getLocation());
    }

    @Test
    void getPrice() {
        assertEquals(160, testAnimal.getAnimalBug().get(0).getPrice());
    }

    @Test
    void getTimeArray() {
        assertArrayEquals(new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, testAnimal.getAnimalBug().get(0).getTimeArray());
    }

    @Test
    void getMonthArrayNorthern() {
        assertArrayEquals(new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5, 6}, testAnimal.getAnimalBug().get(0).getMonthArrayNorthern());
    }

    @Test
    void getMonthArraySouthern() {
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, testAnimal.getAnimalBug().get(0).getMonthArraySouthern());
    }

    @Test
    void testToString() {
        assertEquals("|    1|    Test-Insekt|  fliegend|  160|", testAnimal.getAnimalBug().get(0).toString());
    }
}