import repository.AnimalRepository;


public class Start {
    public static void main(String[] args) {
        System.out.println("Mit diesem Programm haben Sie die Möglichkeit ein Tierinventar zu erstellen oder " +
                "Abfragen über die Sternis die ein Tier einbringen kann");
        AnimalRepository f = new AnimalRepository();
        System.out.println(f.createhardcodeAnimal().toString());


    }

}
