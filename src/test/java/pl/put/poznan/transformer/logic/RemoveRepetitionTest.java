package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveRepetitionTest {
    private static RemoveRepetition transformer;

    @BeforeAll
    static void setUp() {
        transformer = new RemoveRepetition();
    }

    @Test
    void testExample() {
        assertEquals("Send me a message", transformer.transform("Send me me a message"));
    }

    @Test
    void testTricky() {
        assertEquals("jest: jest! jest.", transformer.transform("jest: jest! jest."));
    }
}