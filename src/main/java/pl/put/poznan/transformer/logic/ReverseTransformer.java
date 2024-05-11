package pl.put.poznan.transformer.logic;

public class ReverseTransformer implements TextTransformer
{
    @Override
    public String transform(String text)
    {
        return new StringBuilder(text).reverse().toString();
    }
}
