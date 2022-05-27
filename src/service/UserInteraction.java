package service;

import model.Animal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInteraction implements UserInteractionInterface {

    public void showFirstMessage(){
        System.out.println("Willkommen zum Animal Crossing: New Horizons Hilfsprogramm");
    }

    public int[] getUserInputForCatchableAnimals(){
        System.out.println("Um dir zu sagen, was du gerade fangen kannst, brauche ich zuerst ein paar Informationen:");
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Liegt deine Insel auf der Nordhalbkugel(1) oder Südhalbkugel(2)?");
        int hemisphere = userInputScanner.nextInt();
        System.out.println("Welcher Monat ist gerade auf deiner Insel? (Beispiel: 1 = Januar, ..., 12 = Dezember)");
        int month = userInputScanner.nextInt();
        System.out.println("Welche Uhrzeit ist auf deiner Insel? (Bitte nur die volle Stunde eingeben. Beispiel: 16 für 16:34 Uhr und 1 für 01:30 Uhr");
        int time = userInputScanner.nextInt();
        return new int[]{hemisphere, month, time};
    }

    public String getUserInputForUserCreation(){
        System.out.println("Mit welchem Benutzer möchtest du das Programm starten?");
        Scanner userNameInput = new Scanner(System.in);
        String userName = userNameInput.next();
        return userName;
    }

    public String getUserInputForInventory(){
        System.out.println("Welches Tier möchtest du deinem Inventar hinzufügen?");
        Scanner animalNameInput = new Scanner(System.in);
        String animalName = animalNameInput.next();
        return animalName;
    }

    @Override
    public void getNextAction(InformationService informationService, UserService userService, String userName, Animal hardcodedAnimal) throws FileNotFoundException {
        while(true) {
            System.out.println("Möchtest du ein Tier zum Inventar hinzufügen(1), dein Inventar anzeigen(2) oder möchtest du wissen, was du gerade fangen kannst(3)? Zum Beenden bitte die 4 eingeben.");
            Scanner nextActionInput = new Scanner(System.in);
            int nextAction = nextActionInput.nextInt();
            if (nextAction == 1) {
                String animalName = getUserInputForInventory();
                userService.addAnimalToUserFile(userName, animalName, userService, hardcodedAnimal);
            } else if (nextAction == 2) {
                userService.OutputAllAnimalsOfInventory(userName);
            } else if (nextAction == 3) {
                int[] userInput = getUserInputForCatchableAnimals();
                informationService.getCatchableAnimals(userInput, hardcodedAnimal);
            } else if (nextAction == 4) {
                System.exit(0);
            } else {
                System.out.println("Bitte gebe 1, 2, 3 oder 4 ein.");
                getNextAction(informationService, userService, userName, hardcodedAnimal);
            }
        }
    }
}
