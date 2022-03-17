package service;

import model.Animal;
import repository.AnimalRepository;

public class SetupService {

    public void firstSetup(){
        AnimalRepository f = new AnimalRepository();
        Animal hardcodedAnimal = f.createhardcodeAnimal();
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
