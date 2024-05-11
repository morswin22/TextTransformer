package pl.put.poznan.transformer.logic;

import java.util.List;

public class TextTransformerService
{
    public String transform(String text, List<String> operations)
    {
        var transformers = TextTransformerFactory.createTransformers(operations);

        var processedText = text;

        for (var transformer : transformers)
            processedText = transformer.transform(processedText);

        return processedText;
    }
}
