package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcronymTransformerTest {
    private static AcronymTransformer transformer;

    @BeforeAll
    static void setUp() {
        transformer = new AcronymTransformer();
    }

    @Test
    void testEG() {
        assertEquals("Bread is, e.g. rolls", transformer.transform("Bread is, for example rolls"));
        assertEquals("BREAD IS, E.G. ROLLS", transformer.transform("BREAD IS, FOR EXAMPLE ROLLS"));
        assertEquals("E.g. rolls", transformer.transform("For example rolls"));
        assertEquals("E.g. rolls e.g.", transformer.transform("For example rolls for example"));
    }

    @Test
    void testIA() {
        assertEquals("Bread is, i.a. rolls", transformer.transform("Bread is, among others rolls"));
        assertEquals("BREAD IS, I.A. ROLLS", transformer.transform("BREAD IS, AMONG OTHERS ROLLS"));
        assertEquals("I.a. rolls", transformer.transform("Among others rolls"));
        assertEquals("I.a. rolls i.a.", transformer.transform("Among others rolls among others"));
    }

    @Test
    void testASO() {
        assertEquals("Bread is, aso rolls", transformer.transform("Bread is, and so on rolls"));
        assertEquals("BREAD IS, ASO ROLLS", transformer.transform("BREAD IS, AND SO ON ROLLS"));
        assertEquals("Aso rolls", transformer.transform("And so on rolls"));
        assertEquals("Aso rolls aso", transformer.transform("And so on rolls and so on"));
    }
}