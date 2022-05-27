package service;

import model.Animal;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserServiceInterface {
    public void createDirectory();

    public void createUserFile(String userName);

    public void addAnimalToUserFile(String userName, String animalName, UserService userService, Animal hardcodedAnimal);

    public boolean checkIfAnimalExists(Animal allAnimals, String animalName);

    public void addCheckedAnimalToUserFile(String userName, String animalName);

    public boolean checkIfAnimalExistsInInventory(String userName, String animalName) throws IOException;

    public void OutputAllAnimalsOfInventory(String userName) throws FileNotFoundException;
}
