package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInteractionTest {

    UserInteraction userInteraction;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        userInteraction = new UserInteraction();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void showFirstMessage() {
        userInteraction.showFirstMessage();
        assertTrue(outputStream.toString().contains("Willkommen zum Animal Crossing: New Horizons Hilfsprogramm"));
    }

    @Test
    void getUserInputForCatchableAnimals() {
    }

    @Test
    void getUserInputForUserCreation() {
    }

    @Test
    void getUserInputForInventory() {
    }

    @Test
    void getNextAction() {
    }
}