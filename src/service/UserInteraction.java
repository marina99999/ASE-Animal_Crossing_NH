package service;

import model.Animal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInteraction {

    public void showFirstMessage(){
        System.out.println("Willkommen zum Animal Crossing: New Horizons Hilfsprogramm");
    }

    public int[] getUserInputForCatchableAnimals(){
        System.out.println("Um dir zu sagen, was du gerade fangen kannst, brauche ich zuerst ein paar Informationen:");
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Liegt deine Insel auf der Nordhalbkugel(1) oder Südhalbkugel(2)?");
        int hemisphere = userInputScanner.nextInt();
        System.out.printf("Welcher Monat ist gerade auf deiner Insel? (Beispiel: 1 = Januar, ..., 12 = Dezember)");
        int month = userInputScanner.nextInt();
        System.out.println("Welche Uhrzeit ist auf deiner Insel? (Bitte nur die volle Stunde eingeben. Beispiel: 16 für 16:34 Uhr und 1 für 01:30 Uhr");
        int time = userInputScanner.nextInt();
        int[] userInput = {hemisphere,month,time};
        return userInput;
    }

    public String getUserInputForUserCreation(){
        System.out.println("Mit welchem Benutzer möchtest du das Programm starten?");
        Scanner userNameInput = new Scanner(System.in);
        String userName = userNameInput.next();
        //userNameInput.close();
        return userName;
    }

    public String getUserInputForInventory(){
        System.out.println("Welches Tier möchtest du deinem Inventar hinzufügen?");
        Scanner animalNameInput = new Scanner(System.in);
        String animalName = animalNameInput.next();
        //animalNameInput.close();
        return animalName;
    }

    public void getNextAction(InformationService informationService, UserService userService, String userName, Animal hardcodedAnimal) throws FileNotFoundException {
        while(true) {
            System.out.println("Möchtest du ein Tier zum Inventar hinzufügen(1), dein Inventar anzeigen(2) oder möchtest du wissen, was du gerade fangen kannst(3)? Zum Beenden bitte die 4 eingeben.");
            Scanner nextActionInput = new Scanner(System.in);
            int nextAction = nextActionInput.nextInt();
            //nextActionInput.close();
            if (nextAction == 1) {
                String animalName = getUserInputForInventory();
                userService.addAnimalToUserFile(userName, animalName, userService, hardcodedAnimal);
            } else if (nextAction == 2) {
                userService.OutputAllAnimal(userName);
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
