package service;

import model.Animal;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServiceMock implements UserServiceInterface{
    @Override
    public void createDirectory() {    }

    @Override
    public void createUserFile(String userName) {    }

    @Override
    public void addAnimalToUserFile(String userName, String animalName, UserService userService, Animal hardcodedAnimal) {    }

    @Override
    public boolean checkIfAnimalExists(Animal allAnimals, String animalName) {
        return true;
    }

    @Override
    public void addCheckedAnimalToUserFile(String userName, String animalName) {
    }

    @Override
    public boolean checkIfAnimalExistsInInventory(String userName, String animalName) {
        return true;
    }

    @Override
    public void OutputAllAnimalsOfInventory(String userName) throws FileNotFoundException {
        System.out.println("Testoutput");
    }
}
