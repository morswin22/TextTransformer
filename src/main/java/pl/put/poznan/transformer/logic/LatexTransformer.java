package pl.put.poznan.transformer.logic;

import java.util.regex.Matcher;

public class LatexTransformer implements TextTransformer {
    @Override
    public String transform(String text) {
        return text
                .replaceAll("\\$", Matcher.quoteReplacement("\\$"))
                .replaceAll("&", Matcher.quoteReplacement("\\&"));
    }
}
