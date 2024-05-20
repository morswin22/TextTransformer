package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTransformerTest {
    private static WordCounterTransformer wordCounterTransformer;

    @BeforeEach
    void setUp() {
        wordCounterTransformer = new WordCounterTransformer();
    }

    @Test
    void testBasicExamples() {
        assertEquals("2 words", wordCounterTransformer.transform("Hello world"));
        assertEquals("2 words", wordCounterTransformer.transform("Hello    world"));
        assertEquals("2 words", wordCounterTransformer.transform("    Hello world    "));
        assertEquals("4 words", wordCounterTransformer.transform("Test    Hello world    Test2"));
    }

    @Test
    void testComplexExamples() {
        assertEquals("5 words", wordCounterTransformer.transform("Hello---asdas asdzxc-2112 asdas#!@#!@as  !!!!"));
        assertEquals("3 words", wordCounterTransformer.transform("4124-124 12-12 3123-5112"));
    }

    @Test
    void testOneWord() {
        assertEquals("1 word", wordCounterTransformer.transform("hello"));
    }

    @Test
    void testJustNumbers() {
        assertEquals("1 word", wordCounterTransformer.transform("-123-"));
        assertEquals("6 words", wordCounterTransformer.transform("123 12 12 21 1 2134 "));
    }
}