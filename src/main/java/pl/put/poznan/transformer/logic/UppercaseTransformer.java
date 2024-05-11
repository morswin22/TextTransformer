package pl.put.poznan.transformer.logic;

public class UppercaseTransformer implements TextTransformer
{
    @Override
    public String transform(String text)
    {
        return text.toUpperCase();
    }
}
