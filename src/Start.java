import model.Animal;
import model.Fish;
import repository.AnimalRepository;


public class Start {
    public static void main(String[] args) {
        System.out.println("Mit diesem Programm haben Sie die Möglichkeit ein Tierinventar zu erstellen oder " +
                "Abfragen über die Sternis die ein Tier einbringen kann");
        AnimalRepository f = new AnimalRepository();
        Animal hardcodedAnimal = f.createhardcodeAnimal();
        System.out.println(hardcodedAnimal.toString());
        UserInteraction user = new UserInteraction();
        int[] get = user.getUserInputForCatchableAnimals();
        hardcodedAnimal.getAnimalFish().get(1).getCachableFish(get, hardcodedAnimal);
        hardcodedAnimal.getAnimalBug().get(1).getCachableBug(get, hardcodedAnimal);
        hardcodedAnimal.getAnimalSea().get(1).getCachableSea(get, hardcodedAnimal);


    }

}
