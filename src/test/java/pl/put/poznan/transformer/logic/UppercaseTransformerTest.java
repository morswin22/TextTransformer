package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UppercaseTransformerTest
{
    private static UppercaseTransformer uppercaseTransformer;

    @BeforeAll
    static void setUp()
    {
        uppercaseTransformer = new UppercaseTransformer();
    }

    @Test
    void testUppercase()
    {
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("hello world"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("Hello world"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("HELLO WORLD"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("hELLO WORLD"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("Hello World"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("HELLO WORLD"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("hELLO WORLD"));
        assertEquals("HELLO WORLD", uppercaseTransformer.transform("Hello World"));
    }

    @Test
    void testUppercaseWithDigits()
    {
        assertEquals("HELLO 1WORLD", uppercaseTransformer.transform("hello 1world"));
    }

    @Test
    void testUppercaseWithSpecialCharacters()
    {
        assertEquals("HELLO !WORLD", uppercaseTransformer.transform("hello !world"));
    }

    @Test
    void testUppercaseWithEmptyString()
    {
        assertEquals("", uppercaseTransformer.transform(""));
    }

    @Test
    void testUppercaseWithSingleWord()
    {
        assertEquals("HELLO", uppercaseTransformer.transform("hello"));
        assertEquals("HELLO", uppercaseTransformer.transform("heLLo"));
    }
}
