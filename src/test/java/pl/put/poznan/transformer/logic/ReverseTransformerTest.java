package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTransformerTest {
    private static ReverseTransformer transformer;

    @BeforeAll
    static void setUp() {
        transformer = new ReverseTransformer();
    }

    @Test
    void testExample() {
        assertEquals("KerIm", transformer.transform("MirEk"));
    }

    @Test
    void testUTF8() {
        assertEquals("łba", transformer.transform("abł"));
        assertEquals("Łba", transformer.transform("Abł"));
        assertEquals("ŁBA", transformer.transform("ABŁ"));
        assertEquals("): !dałKYZRP ikżęic tsEJ 321 ZARet OT ela", transformer.transform("AlE to TERAZ 123 jest CIĘŻKI PRZykłAD! :)"));
    }
}