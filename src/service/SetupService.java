package service;

import model.Animal;
import repository.AnimalRepository;

import java.io.FileNotFoundException;

public class SetupService {
    public void firstSetup() throws FileNotFoundException {
        AnimalRepository f = new AnimalRepository();
        Animal hardcodedAnimal = f.createHardcodedAnimal();
        UserInteraction user = new UserInteraction();
        UserService userService = new UserService();
        InformationService informationService = new InformationService();

        user.showFirstMessage();
        userService.createDirectory();
        String userName = user.getUserInputForUserCreation();
        userService.createUserFile(userName);
        user.getNextAction(informationService, userService, userName, hardcodedAnimal);

    }
}
