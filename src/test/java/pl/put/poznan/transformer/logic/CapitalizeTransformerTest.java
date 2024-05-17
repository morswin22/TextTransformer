package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalizeTransformerTest
{
    private static CapitalizeTransformer capitalizeTransformer;

    @BeforeAll
    static void setUp()
    {
        capitalizeTransformer = new CapitalizeTransformer();
    }

    @Test
    void testCapitalize()
    {
        assertEquals("Hello World", capitalizeTransformer.transform("hello world"));
        assertEquals("Hello World", capitalizeTransformer.transform("Hello world"));
        assertEquals("Hello World", capitalizeTransformer.transform("HELLO WORLD"));
        assertEquals("Hello World", capitalizeTransformer.transform("hELLO WORLD"));
        assertEquals("Hello World", capitalizeTransformer.transform("Hello World"));
        assertEquals("Hello World", capitalizeTransformer.transform("HELLO WORLD"));
        assertEquals("Hello World", capitalizeTransformer.transform("hELLO WORLD"));
        assertEquals("Hello World", capitalizeTransformer.transform("Hello World"));
    }

    @Test
    void testCapitalizeWithDigits()
    {
        assertEquals("Hello 1world", capitalizeTransformer.transform("hello 1world"));
    }

    @Test
    void testCapitalizeWithSpecialCharacters()
    {
        assertEquals("Hello !world", capitalizeTransformer.transform("hello !world"));
    }

    @Test
    void testCapitalizeWithEmptyString()
    {
        assertEquals("", capitalizeTransformer.transform(""));
    }

    @Test
    void testCapitalizeWithSingleWord()
    {
        assertEquals("Hello", capitalizeTransformer.transform("hello"));
        assertEquals("Hello", capitalizeTransformer.transform("heLLo"));
    }
}
