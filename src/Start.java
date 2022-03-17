import model.Animal;
import repository.AnimalRepository;
import service.SetupService;
import service.UserService;


public class Start {
    public static void main(String[] args) {
        SetupService setupService = new SetupService();
        setupService.firstSetup();
    }

}
