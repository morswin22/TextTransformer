package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowercaseTransformerTest
{
    private static LowercaseTransformer lowercaseTransformer;

    @BeforeAll
    static void setUp()
    {
        lowercaseTransformer = new LowercaseTransformer();
    }

    @Test
    void testLowercase()
    {
        assertEquals("hello world", lowercaseTransformer.transform("hello world"));
        assertEquals("hello world", lowercaseTransformer.transform("Hello world"));
        assertEquals("hello world", lowercaseTransformer.transform("HELLO WORLD"));
        assertEquals("hello world", lowercaseTransformer.transform("hELLO WORLD"));
        assertEquals("hello world", lowercaseTransformer.transform("Hello World"));
        assertEquals("hello world", lowercaseTransformer.transform("HELLO WORLD"));
        assertEquals("hello world", lowercaseTransformer.transform("hELLO WORLD"));
        assertEquals("hello world", lowercaseTransformer.transform("Hello World"));
    }

    @Test
    void testLowercaseWithDigits()
    {
        assertEquals("hello 1world", lowercaseTransformer.transform("hello 1world"));
    }

    @Test
    void testLowercaseWithSpecialCharacters()
    {
        assertEquals("hello !world", lowercaseTransformer.transform("hello !world"));
    }

    @Test
    void testLowercaseWithEmptyString()
    {
        assertEquals("", lowercaseTransformer.transform(""));
    }

    @Test
    void testLowercaseWithSingleWord()
    {
        assertEquals("hello", lowercaseTransformer.transform("hello"));
        assertEquals("hello", lowercaseTransformer.transform("heLLo"));
    }
}
