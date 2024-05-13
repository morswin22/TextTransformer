package pl.put.poznan.transformer.logic;

/**
 * This interface is used to define the contract for text transformers.
 * Each text transformer should implement this interface.
 * The transform method should take a string as an argument and return a transformed string.
 * The transformation should be defined by the implementing class.
 * The transform method should not modify the original string.
 * The transform method should return a new string with the transformation applied.
 * The transform method should not return null.
 * The transform method should return an empty string if the input string is empty.
 * The transform method should not return a string with leading or trailing whitespaces.
 */
public interface TextTransformer
{
    /**
     * This method should take a string as an argument and return a transformed string.
     * The transformation should be defined by the implementing class.
     * @param text The input string to be transformed.
     * @return The transformed string.
     */
    public String transform(String text);
}
