package pl.put.poznan.transformer.logic;

public class LowercaseTransformer implements TextTransformer
{
    @Override
    public String transform(String text)
    {
        return text.toLowerCase();
    }
}
