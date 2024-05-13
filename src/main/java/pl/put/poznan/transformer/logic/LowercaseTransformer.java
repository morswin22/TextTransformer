package pl.put.poznan.transformer.logic;

/**
 * This class is responsible for transforming text to lowercase.
 */
public class LowercaseTransformer implements TextTransformer
{
    /**
     * This method transforms the input text to lowercase.
     * @param text The input text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text)
    {
        return text.toLowerCase();
    }
}
