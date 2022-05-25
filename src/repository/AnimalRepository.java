package repository;

import model.Animal;
import model.Bug;
import model.Fish;
import model.Sea;

import java.util.ArrayList;
import java.util.List;

public final class AnimalRepository {
    private List<Fish> animalFish = new ArrayList<>();
    private List<Bug> animalBug = new ArrayList<>();
    private List<Sea> animalSea = new ArrayList<>();

    private final int[] timeArrayWholeDay = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
    private final int[] monthArrayWholeYear = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static AnimalRepository INSTANCE;

    public AnimalRepository() {
        createHardcodedAnimal();
    }

    public static AnimalRepository getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AnimalRepository();
        }
        return INSTANCE;
    }

    public Animal createHardcodedAnimal() {
        Fish bitterling = new Fish(1, "Bitterling", "winzig(1)", "Fluss", 900, timeArrayWholeDay, new int[]{11, 12, 1, 2, 3}, new int[]{5, 6, 7, 8, 9});
        Fish doebel = new Fish(2, "Döbel", "winzig(1)", "Fluss", 200, new int[]{9, 10, 11, 12, 13, 14, 15}, monthArrayWholeYear, monthArrayWholeYear);
        animalFish.add(bitterling);
        animalFish.add(doebel);

        Bug kohlweissling = new Bug(1, "Kohlweißling", "fliegend", 160, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5, 6}, new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        Bug zitronenfalter = new Bug(2, "Zitronenfalter", "fliegend", 160, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, new int[]{3, 4, 5, 6, 9, 10}, new int[]{9, 10, 11, 12, 3, 4});
        animalBug.add(kohlweissling);
        animalBug.add(zitronenfalter);

        Sea wakameAlge = new Sea(1, "Wakame-Alge", "groß", 600, "stillstehend", timeArrayWholeDay, new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7}, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 1});
        Sea kriechsprossalge = new Sea(2, "Kriechsprossalge", "klein", 900, "stillstehend", timeArrayWholeDay, new int[]{6, 7, 8, 9}, new int[]{12, 1, 2, 3});
        animalSea.add(wakameAlge);
        animalSea.add(kriechsprossalge);

        Animal hardcodedAnimal = new Animal(animalFish, animalBug, animalSea);
        return hardcodedAnimal;
    }
}
