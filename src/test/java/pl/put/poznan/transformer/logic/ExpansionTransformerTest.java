package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpansionTransformerTest {
    private static ExpansionTransformer transformer;

    @BeforeAll
    static void setUp() {
        transformer = new ExpansionTransformer();
    }

    @Test
    void testProf() {
        assertEquals("professor was late for classes", transformer.transform("prof. was late for classes"));
        assertEquals("PROFESSOR WAS LATE FOR CLASSES", transformer.transform("PROF. WAS LATE FOR CLASSES"));
        assertEquals("Professor was late for classes", transformer.transform("Prof. was late for classes"));
        assertEquals("Professor was late for classes Professor", transformer.transform("Prof. was late for classes Prof."));
    }

    @Test
    void testDr() {
        assertEquals("doctor was late for classes", transformer.transform("dr was late for classes"));
        assertEquals("DOCTOR WAS LATE FOR CLASSES", transformer.transform("DR WAS LATE FOR CLASSES"));
        assertEquals("Doctor was late for classes", transformer.transform("Dr was late for classes"));
        assertEquals("Doctor was late for classes Doctor", transformer.transform("Dr was late for classes Dr"));
    }

    @Test
    void testEG() {
        assertEquals("Bread is, for example rolls", transformer.transform("Bread is, e.g. rolls"));
        assertEquals("BREAD IS, FOR EXAMPLE ROLLS", transformer.transform("BREAD IS, E.G. ROLLS"));
        assertEquals("For example rolls", transformer.transform("E.g. rolls"));
        assertEquals("For example rolls for example", transformer.transform("E.g. rolls e.g."));
    }

    @Test
    void testASO() {
        assertEquals("Bread is, and so on rolls", transformer.transform("Bread is, aso rolls"));
        assertEquals("BREAD IS, AND SO ON ROLLS", transformer.transform("BREAD IS, ASO ROLLS"));
        assertEquals("And so on rolls", transformer.transform("Aso rolls"));
        assertEquals("And so on rolls and so on", transformer.transform("Aso rolls aso"));
    }
}