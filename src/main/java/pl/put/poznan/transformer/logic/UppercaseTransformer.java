package pl.put.poznan.transformer.logic;

/**
 * This class is responsible for transforming text to uppercase.
 */
public class UppercaseTransformer implements TextTransformer
{
    /**
     * This method transforms the input text to uppercase.
     * @param text The input text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text)
    {
        return text.toUpperCase();
    }
}
