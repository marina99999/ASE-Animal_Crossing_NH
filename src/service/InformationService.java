package service;

import model.Animal;
import model.Fish;

public class InformationService {

    public void getCatchableAnimals(int[] userInput, Animal hardcodedAnimal){
        int hemisphere = userInput[0];
        int month = userInput[1];
        int time = userInput[2];
        hardcodedAnimal.getAnimalFish().get(1).getCachableFish(userInput, hardcodedAnimal);
        hardcodedAnimal.getAnimalSea().get(1).getCachableSea(userInput, hardcodedAnimal);
        hardcodedAnimal.getAnimalBug().get(1).getCachableBug(userInput,hardcodedAnimal);

    }
}
