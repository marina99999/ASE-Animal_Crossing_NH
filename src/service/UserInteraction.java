package service;

import model.Animal;

import java.util.Scanner;

public class UserInteraction {

    public void showFirstMessage(){
        System.out.println("Mit diesem Programm haben Sie die Möglichkeit ein Tierinventar zu erstellen oder " +
                "Abfragen über die Sternis die ein Tier einbringen kann");
    }

    public int[] getUserInputForCatchableAnimals(){
        System.out.println("Um dir zu sagen, was du gerade fangen kannst, brauche ich erst ein paar Informationen?");
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Liegt deine Insel auf der Nordhalbkugel(1) oder Südhalbkugel(2)?");
        int hemisphere = userInputScanner.nextInt();
        System.out.printf("Welcher Monat ist gerade auf deiner Insel? (Beispiel 1 = Januar ,..., 12 = Dezember) ");
        int month = userInputScanner.nextInt();
        System.out.println("Welche Uhrzeit ist auf deiner Insel? (Bitte nur die volle Stunde eingeben Beispiel: 16 für 16:34 und 1 für 01:30");
        int time = userInputScanner.nextInt();
        int[] userInput = {hemisphere,month,time};
        return userInput;
    }

    public String getUserInputForUserCreation(){
        System.out.println("Mit welchem Benutzer möchtest du das Programm starten?");
        Scanner userNameInput = new Scanner(System.in);
        String userName = userNameInput.next();
        userNameInput.close();
        return userName;
    }

    public String getUserInputForInventory(){
        System.out.println("Welches Tier möchtest du dem Inventar hinzufügen?");
        Scanner animalNameInput = new Scanner(System.in);
        String animalName = animalNameInput.next();
        animalNameInput.close();
        return animalName;
    }

    public void getNextAction(InformationService informationService, UserService userService, String userName, Animal hardcodedAnimal){
        System.out.println("Möchtest du ein Tier zum Inventar hinzufügen(1) oder möchtest du wissen was du gerade fangen kannst(2)?");
        Scanner nextActionInput = new Scanner(System.in);
        int nextAction = nextActionInput.nextInt();
        nextActionInput.close();
        if(nextAction ==1){
            String animalName = getUserInputForInventory();
            userService.addAnimalToUserFile(userName, animalName, userService, hardcodedAnimal);
        } else if(nextAction == 2){
            int[] userInput = getUserInputForCatchableAnimals();
            informationService.getCatchableAnimals(userInput);
        } else {
            System.out.println("Bitte gebe 1 oder 2 ein.");
            getNextAction(informationService,userService, userName, hardcodedAnimal);
        }
    }
}
