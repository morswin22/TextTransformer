package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer implements TextTransformer
{
    @Override
    public String transform(String text)
    {
        String[] words = text.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words)
        {
            if (word.isEmpty())
                continue;

            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");

        }

        return result.toString().trim();
    }
}
