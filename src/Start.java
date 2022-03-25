import model.Animal;
import repository.AnimalRepository;
import service.SetupService;
import service.UserService;

import java.io.FileNotFoundException;


public class Start {
    public static void main(String[] args) throws FileNotFoundException {
        SetupService setupService = new SetupService();
        setupService.firstSetup();
    }

}
