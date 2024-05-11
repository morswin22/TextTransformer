package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatexTransformerTest {
    private static LatexTransformer transformer;

    @BeforeAll
    static void setUp() {
        transformer = new LatexTransformer();
    }

    @Test
    void testAmpersand() {
        assertEquals("loRem \\& ImpsUm 32!@#%^\\&*()<>?/;'[]", transformer.transform("loRem & ImpsUm 32!@#%^&*()<>?/;'[]"));
    }

    @Test
    void testDollar() {
        assertEquals("loRem \\$ ImpsUm 32!@#%^\\$*()<>?/;'[]", transformer.transform("loRem $ ImpsUm 32!@#%^$*()<>?/;'[]"));
    }
}