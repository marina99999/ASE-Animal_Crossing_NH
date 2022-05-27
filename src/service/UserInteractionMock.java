package service;

import model.Animal;

import java.io.FileNotFoundException;

public class UserInteractionMock implements UserInteractionInterface{

    @Override
    public int[] getUserInputForCatchableAnimals() {
        return new int[] {1, 5, 20};
    }

    @Override
    public String getUserInputForUserCreation() {
        return "Testnutzer";
    }

    @Override
    public String getUserInputForInventory() {
        return "Bitterling";
    }

    @Override
    public void getNextAction(InformationService informationService, UserService userService, String userName, Animal hardcodedAnimal) throws FileNotFoundException {

        String animalName = getUserInputForInventory();
        userService.addAnimalToUserFile(userName, animalName, userService, hardcodedAnimal);

        userService.OutputAllAnimalsOfInventory(userName);

        int[] userInput = getUserInputForCatchableAnimals();
        informationService.getCatchableAnimals(userInput, hardcodedAnimal);
    }
}
