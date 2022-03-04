package model;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private List<Fish> animalFish;
    private List<Bug> animalBug;
    private List<Sea> animalSea;

    public Animal(List<Fish> animalFish, List<Bug> animalBug, List<Sea> animalSea) {
        this.animalFish = animalFish;
        this.animalBug = animalBug;
        this.animalSea = animalSea;
    }


    public List<Fish> getAnimalFish() {
        return animalFish;
    }

    public List<Bug> getAnimalBug() {
        return animalBug;
    }

    public List<Sea> getAnimalSea() {
        return animalSea;
    }
}
