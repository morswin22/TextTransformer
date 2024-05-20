package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ShuffleTransformerTest
{
    private static ShuffleTransformer shuffleTransformer;

    @BeforeAll
    static void setUp()
    {
        shuffleTransformer = new ShuffleTransformer();
    }

    @Test
    void testAnagram()
    {
        assertContainsSameCharacters("hello world", shuffleTransformer.transform("hello world"));
        assertContainsSameCharacters("Hello world", shuffleTransformer.transform("Hello world"));
        assertContainsSameCharacters("HELLO WORLD", shuffleTransformer.transform("HELLO WORLD"));
        assertContainsSameCharacters("hELLO WORLD", shuffleTransformer.transform("hELLO WORLD"));
        assertContainsSameCharacters("Hello World", shuffleTransformer.transform("Hello World"));
        assertContainsSameCharacters("HELLO WORLD", shuffleTransformer.transform("HELLO WORLD"));
        assertContainsSameCharacters("hELLO WORLD", shuffleTransformer.transform("hELLO WORLD"));
        assertContainsSameCharacters("Hello World", shuffleTransformer.transform("Hello World"));
    }

    @Test
    void testAnagramWithDigits()
    {
        assertContainsSameCharacters("1hello world", shuffleTransformer.transform("1hello world"));
    }

    @Test
    void testAnagramWithSpecialCharacters()
    {
        assertContainsSameCharacters("!hello world", shuffleTransformer.transform("!hello world"));
    }

    @Test
    void testAnagramWithEmptyString()
    {
        assertContainsSameCharacters("", shuffleTransformer.transform(""));
    }

    @Test
    void testAnagramWithSingleWord()
    {
        assertContainsSameCharacters("hello", shuffleTransformer.transform("hello"));
        assertContainsSameCharacters("heLLo", shuffleTransformer.transform("heLLo"));
    }

    private void assertContainsSameCharacters(String input, String shuffled)
    {
        if (!input.isEmpty())
            assertNotEquals(input, shuffled);

        assertEquals(input.length(), shuffled.length());

        char[] a1 = input.toCharArray();
        char[] a2 = shuffled.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);

        assertArrayEquals(a1, a2);
    }

}
