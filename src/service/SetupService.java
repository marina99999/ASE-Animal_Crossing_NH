package service;

import model.Animal;
import repository.AnimalRepository;

import java.io.FileNotFoundException;

public class SetupService {
    public void firstSetup() throws FileNotFoundException {
        AnimalRepository animalRepository = new AnimalRepository();
        Animal hardcodedAnimal = animalRepository.createHardcodedAnimal();
        UserInteraction userInteraction = new UserInteraction();
        UserService userService = new UserService();
        InformationService informationService = new InformationService();

        userInteraction.showFirstMessage();
        userService.createDirectory();
        String userName = userInteraction.getUserInputForUserCreation();
        userService.createUserFile(userName);
        userInteraction.getNextAction(informationService, userService, userName, hardcodedAnimal);
    }
}
