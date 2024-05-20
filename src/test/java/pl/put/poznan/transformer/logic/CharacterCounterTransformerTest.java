package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterCounterTransformerTest {
    private static CharacterCounterTransformer characterCounterTransformer;

    @BeforeEach
    void setUp() {
        characterCounterTransformer = new CharacterCounterTransformer();
    }

    @Test
    void testCharacterCounting() {
        Assertions.assertEquals("11 characters", characterCounterTransformer.transform("Hello world"));
    }

    @Test
    void testOneCharacter() {
        Assertions.assertEquals("1 character", characterCounterTransformer.transform("a"));
    }
}
