package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for transforming text to an anagram.
 */
public class AnagramTransformer implements TextTransformer
{
    /**
     * This method transforms the input text to an anagram.
     *
     * @param text The input text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text)
    {
        if (text.isEmpty())
            return "";

        StringBuilder anagram = null;
        while (anagram == null || anagram.toString().equals(text))
        {
            List<Character> characters = new ArrayList<>();
            for (char c : text.toCharArray())
                characters.add(c);


            Collections.shuffle(characters);

            anagram = new StringBuilder();
            for (char c : characters)
                anagram.append(c);

        }
        return anagram.toString();
    }
}
