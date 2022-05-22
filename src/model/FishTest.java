package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FishTest {

    private Animal testAnimal;
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();
    Fish testFish = new Fish(1, "Test-Fisch", "winzig(1)", "Fluss", 900, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}, new int[]{11, 12, 1, 2, 3}, new int[]{5, 6, 7, 8, 9});

    @BeforeEach
    void setUp() {
        animalFish.add(testFish);
        testAnimal = new Animal(animalFish, animalBug, animalSea);
    }

    @Test
    void getCatchableFish() {
        assertEquals(1, testAnimal.getAnimalFish().get(0).getCatchableFish(new int[]{1, 12, 12}, testAnimal).size());
        assertTrue(testAnimal.getAnimalFish().get(0).getCatchableFish(new int[]{1, 12, 12}, testAnimal).contains(testFish));
    }

    @Test
    void testToString() {
        assertEquals("|    1|     Test-Fisch| winzig(1)|     Fluss|  900|", testAnimal.getAnimalFish().get(0).toString());
    }

    @Test
    void getFishId() {
        assertEquals(1, testAnimal.getAnimalFish().get(0).getFishId());
    }

    @Test
    void getName() {
        assertEquals("Test-Fisch", testAnimal.getAnimalFish().get(0).getName());
    }

    @Test
    void getShadow() {
        assertEquals("winzig(1)", testAnimal.getAnimalFish().get(0).getShadow());
    }

    @Test
    void getLocation() {
        assertEquals("Fluss", testAnimal.getAnimalFish().get(0).getLocation());
    }

    @Test
    void getPrice() {
        assertEquals(900, testAnimal.getAnimalFish().get(0).getPrice());
    }

    @Test
    void getTimeArray() {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}, testAnimal.getAnimalFish().get(0).getTimeArray());
    }

    @Test
    void getMonthArrayNorthern() {
        assertArrayEquals(new int[]{11, 12, 1, 2, 3}, testAnimal.getAnimalFish().get(0).getMonthArrayNorthern());
    }

    @Test
    void getMonthArraySouthern() {
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, testAnimal.getAnimalFish().get(0).getMonthArraySouthern());
    }
}