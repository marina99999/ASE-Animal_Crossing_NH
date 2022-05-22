package model;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private Animal testAnimal;
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();

    @BeforeEach
    public void init() {
        Fish testFish = new Fish(1, "Test-Fisch", "winzig(1)", "Fluss", 900, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}, new int[]{11, 12, 1, 2, 3}, new int[]{5, 6, 7, 8, 9});
        animalFish.add(testFish);

        Bug testBug = new Bug(1, "Test-Insekt", "fliegend", 160, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5, 6}, new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        animalBug.add(testBug);

        Sea testSea = new Sea(1, "Test-Meerestier", "groß", 600, "stillstehend", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23}, new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7}, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 1});
        animalSea.add(testSea);

        testAnimal = new Animal(animalFish, animalBug, animalSea);
    }

    @org.junit.jupiter.api.Test
    void getAnimalFish() {
        assertEquals(1, testAnimal.getAnimalFish().size());
        assertEquals(1, testAnimal.getAnimalFish().get(0).getFishId());
        assertTrue(testAnimal.getAnimalFish().stream().anyMatch(o -> o.getName().equals("Test-Fisch")));
        assertEquals("|    1|     Test-Fisch| winzig(1)|     Fluss|  900|" , testAnimal.getAnimalFish().get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void getAnimalBug() {
        assertEquals(1, testAnimal.getAnimalBug().size());
        assertEquals(1, testAnimal.getAnimalBug().get(0).getBugId());
        assertTrue(testAnimal.getAnimalBug().stream().anyMatch(o -> o.getName().equals("Test-Insekt")));
        assertEquals("|    1|    Test-Insekt|  fliegend|  160|", testAnimal.getAnimalBug().get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void getAnimalSea() {
        assertEquals(1, testAnimal.getAnimalSea().size());
        assertEquals(1, testAnimal.getAnimalSea().get(0).getSeaId());
        assertTrue(testAnimal.getAnimalSea().stream().anyMatch(o -> o.getName().equals("Test-Meerestier")));
        assertEquals("|    1|     Test-Meerestier|      groß|   stillstehend|  600|", testAnimal.getAnimalSea().get(0).toString());
    }
}