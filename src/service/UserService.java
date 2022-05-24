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
            System.out.println("Das Tier existiert leider nicht in ACNH, probiere es mit einem anderen Tier!");
            return false;
        }
    }

    public void addCheckedAnimalToUserFile(String userName, String animalName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("userDirectory\\" + userName + ".txt", true))) {
            if (!checkIfAnimalExistsInInventory(userName, animalName)) {
                animalName = animalName.toLowerCase();
                animalName = animalName.substring(0, 1).toUpperCase() + animalName.substring(1);
                pw.println(animalName);
                System.out.println("Tier erfolgreich zu deinem Inventar hinzugefügt!");
            } else {
                System.out.println("Das Tier existiert bereits in deinem Inventar!");
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    public boolean checkIfAnimalExistsInInventory(String userName, String animalName) throws IOException {
        boolean containsAnimalName = false;
        try (BufferedReader br = new BufferedReader(new FileReader("userDirectory\\" + userName + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(animalName.toLowerCase())) {
                    containsAnimalName = true;
                } else {
                    containsAnimalName = false;
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " + e.getMessage());
        }
        return containsAnimalName;
    }

    public void OutputAllAnimalsOfInventory(String userName) throws FileNotFoundException {
        File userInventory = new File("userDirectory\\" + userName + ".txt");
        Scanner scanner = new Scanner(userInventory);
        if (userInventory.length() == 0){
            System.out.println("Dein Inventar ist leer!");
        } else {
            System.out.println("Bisher gefangen:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

}
