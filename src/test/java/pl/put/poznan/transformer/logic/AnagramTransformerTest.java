package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTransformerTest
{
    private static AnagramTransformer anagramTransformer;

    @BeforeAll
    static void setUp()
    {
        anagramTransformer = new AnagramTransformer();
    }

    @Test
    void testAnagram()
    {
        assertContainsSameCharacters("hello world", anagramTransformer.transform("hello world"));
        assertContainsSameCharacters("Hello world", anagramTransformer.transform("Hello world"));
        assertContainsSameCharacters("HELLO WORLD", anagramTransformer.transform("HELLO WORLD"));
        assertContainsSameCharacters("hELLO WORLD", anagramTransformer.transform("hELLO WORLD"));
        assertContainsSameCharacters("Hello World", anagramTransformer.transform("Hello World"));
        assertContainsSameCharacters("HELLO WORLD", anagramTransformer.transform("HELLO WORLD"));
        assertContainsSameCharacters("hELLO WORLD", anagramTransformer.transform("hELLO WORLD"));
        assertContainsSameCharacters("Hello World", anagramTransformer.transform("Hello World"));
    }

    @Test
    void testAnagramWithDigits()
    {
        assertContainsSameCharacters("1hello world", anagramTransformer.transform("1hello world"));
    }

    @Test
    void testAnagramWithSpecialCharacters()
    {
        assertContainsSameCharacters("!hello world", anagramTransformer.transform("!hello world"));
    }

    @Test
    void testAnagramWithEmptyString()
    {
        assertContainsSameCharacters("", anagramTransformer.transform(""));
    }

    @Test
    void testAnagramWithSingleWord()
    {
        assertContainsSameCharacters("hello", anagramTransformer.transform("hello"));
        assertContainsSameCharacters("heLLo", anagramTransformer.transform("heLLo"));
    }

    private void assertContainsSameCharacters(String input, String anagram)
    {
        if (!input.isEmpty())
            assertNotEquals(input, anagram);

        assertEquals(input.length(), anagram.length());

        char[] a1 = input.toCharArray();
        char[] a2 = anagram.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);

        assertArrayEquals(a1, a2);
    }

}
