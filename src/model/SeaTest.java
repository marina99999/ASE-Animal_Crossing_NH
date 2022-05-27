package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeaTest {

    private Animal testAnimal;
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();
    Sea testSea = new Sea(1, "Test-Meerestier", "groß", 600, "stillstehend", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}, new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7}, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 1});

    @BeforeEach
    void setUp() {
        animalSea.add(testSea);
        testAnimal = new Animal(animalFish, animalBug, animalSea);
    }

    @Test
    void getCatchableSea() {
        assertEquals(1, testAnimal.getAnimalSea().get(0).getCatchableSea(new int[]{1, 12, 12}, testAnimal).size());
        assertTrue(testAnimal.getAnimalSea().get(0).getCatchableSea(new int[]{1, 12, 12}, testAnimal).contains(testSea));
    }

    @Test
    void getSeaId() {
        assertEquals(1, testAnimal.getAnimalSea().get(0).getId());
    }

    @Test
    void getName() {
        assertEquals("Test-Meerestier", testAnimal.getAnimalSea().get(0).getName());
    }

    @Test
    void getShadow() {
        assertEquals("groß", testAnimal.getAnimalSea().get(0).getShadow());
    }

    @Test
    void getPrice() {
        assertEquals(600, testAnimal.getAnimalSea().get(0).getPrice());
    }

    @Test
    void getSpeed() {
        assertEquals("stillstehend", testAnimal.getAnimalSea().get(0).getSpeed());
    }

    @Test
    void getTimeArray() {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}, testAnimal.getAnimalSea().get(0).getTimeArray());
    }

    @Test
    void getMonthArrayNorthern() {
        assertArrayEquals(new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7}, testAnimal.getAnimalSea().get(0).getMonthArrayNorthern());
    }

    @Test
    void getMonthArraySouthern() {
        assertArrayEquals(new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 1}, testAnimal.getAnimalSea().get(0).getMonthArraySouthern());
    }

    @Test
    void testToString() {
        assertEquals("|    1|     Test-Meerestier|      groß|   stillstehend|  600|", testAnimal.getAnimalSea().get(0).toString());
    }
}