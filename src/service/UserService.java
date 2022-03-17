package service;

import model.Animal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class UserService {
    File userDirectory = new File("userDirectory");

    public void createDirectory() {
        userDirectory.mkdir();
    }

    public void createUserFile(String userName) {
        File userFile = new File(userDirectory, userName + ".txt");
        try {
            userFile.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating File " +
                    userFile.getAbsolutePath());
        }
    }

    public void addAnimalToUserFile(String userName, String animalName, UserService userService, Animal hardcodedAnimal){
        if(userService.checkAnimalExist(hardcodedAnimal, animalName)){
            userService.addCheckedAnimalToUserFile(userName, animalName);
        }
    }

    public boolean checkAnimalExist(Animal allAnimals, String animalName){
        String animalNameLowerCase = animalName.toLowerCase();
        boolean containBug = allAnimals.getAnimalBug().stream().anyMatch(o -> o.getName().toLowerCase().equals(animalNameLowerCase));
        boolean containSea = allAnimals.getAnimalSea().stream().anyMatch(o -> o.getName().toLowerCase().equals(animalNameLowerCase));
        boolean containFish = allAnimals.getAnimalFish().stream().anyMatch(o -> o.getName().toLowerCase().equals(animalNameLowerCase));;

        if(containBug || containSea || containFish){
            return true;
        } else {
            return false;
        }
    }

    public void addCheckedAnimalToUserFile(String userName, String animalName) {

        Path path = Paths.get(userName + ".txt");
        boolean containsAnimalName = false;
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(userName + ".txt", true)); BufferedReader br = new BufferedReader(new FileReader(userName + ".txt")))
        {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(animalName.toLowerCase())) {
                    containsAnimalName = true;
                }
            }

            if (!containsAnimalName) {
                pw.println(animalName);
            }


        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " +
                    e.getMessage());
        }
    }
}
