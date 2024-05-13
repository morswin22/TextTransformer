package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

// Define the factory class
class TextTransformerFactory {
    public static TextTransformer createTransformer(String type) {
        switch (type.toLowerCase()) {
            case "repetition" :
                return new RemoveRepetition();
            case "reverse":
                return new ReverseTransformer();
            case "lower":
                return new LowercaseTransformer();
            case "upper":
                return new UppercaseTransformer();
            case "number":
                return  new NumberTransformer();
            case "capitalize":
                return new CapitalizeTransformer();
            case "latex":
                return new LatexTransformer();
            case "acronym":
                return new AcronymTransformer();
            case "expansion":
                return new ExpansionTransformer();
            default:
                throw new IllegalArgumentException("Invalid transformation type: " + type);
        }
    }
    public static List<TextTransformer> createTransformers(List<String> types) {
        List<TextTransformer> transformers = new ArrayList<>();
        for (String type : types) {
            transformers.add(createTransformer(type));
        }
        return transformers;
    }
}