package service;

import model.Animal;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void addAnimalToUserFile(String userName, String animalName, UserService userService, Animal hardcodedAnimal) {
        if (userService.checkIfAnimalExists(hardcodedAnimal, animalName)) {
            userService.addCheckedAnimalToUserFile(userName, animalName);
        }
    }

    public boolean checkIfAnimalExists(Animal allAnimals, String animalName) {
        String animalNameLowerCase = animalName.toLowerCase();
        boolean containsBug = allAnimals.getAnimalBug().stream().anyMatch(o -> o.getName().toLowerCase().equals(animalNameLowerCase));
        boolean containsSea = allAnimals.getAnimalSea().stream().anyMatch(o -> o.getName().toLowerCase().equals(animalNameLowerCase));
        boolean containsFish = allAnimals.getAnimalFish().stream().anyMatch(o -> o.getName().toLowerCase().equals(animalNameLowerCase));
        if (containsBug || containsSea || containsFish) {
            return true;
        } else {
            return false;
        }
    }

    public void addCheckedAnimalToUserFile(String userName, String animalName) {

        Path path = Paths.get("userDirectory\\" + userName + ".txt");
        boolean containsAnimalName = false;
        try (PrintWriter pw = new PrintWriter(
                new FileWriter("userDirectory\\" + userName + ".txt", true)); BufferedReader br = new BufferedReader(new FileReader("userDirectory\\" + userName + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(animalName.toLowerCase())) {
                    containsAnimalName = true;
                }
            }
            if (!containsAnimalName) {
                pw.println(animalName);
            } else {
                System.out.println("Das Tier existiert bereits in deinem Inventar");
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " +
                    e.getMessage());
        }
    }

    public void OutputAllAnimalsOfInventory(String userName) throws FileNotFoundException {
        File doc = new File("userDirectory\\" + userName + ".txt");
        Scanner obj = new Scanner(doc);
        System.out.println("Bisher gefangen:");
        while (obj.hasNextLine()) {
            System.out.println(obj.nextLine());
        }

    }

}
