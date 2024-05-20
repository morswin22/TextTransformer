package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for shuffling the text.
 */
public class ShuffleTransformer implements TextTransformer
{
    /**
     * This method is responsible for the shuffle transformation.
     *
     * @param text The input text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text)
    {
        if (text.isEmpty())
            return "";

        StringBuilder shuffle = null;
        while (shuffle == null || shuffle.toString().equals(text))
        {
            List<Character> characters = new ArrayList<>();
            for (char c : text.toCharArray())
                characters.add(c);


            Collections.shuffle(characters);

            shuffle = new StringBuilder();
            for (char c : characters)
                shuffle.append(c);

        }
        return shuffle.toString();
    }
}
