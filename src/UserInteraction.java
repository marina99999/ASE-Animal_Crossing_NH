import java.util.Scanner;

public class UserInteraction {


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
}
