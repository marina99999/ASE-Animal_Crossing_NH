package service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserInteractionTest {

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
}