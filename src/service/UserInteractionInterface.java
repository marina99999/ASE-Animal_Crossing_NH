package service;

import model.Animal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface UserInteractionInterface {
    public int[] getUserInputForCatchableAnimals();

    public String getUserInputForUserCreation();

    public String getUserInputForInventory();

    void getNextAction(InformationService informationService, UserService userService, String userName, Animal hardcodedAnimal) throws FileNotFoundException;
}
