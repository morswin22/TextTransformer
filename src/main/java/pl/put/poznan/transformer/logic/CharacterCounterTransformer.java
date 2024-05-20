package pl.put.poznan.transformer.logic;

public class CharacterCounterTransformer implements TextTransformer {
    @Override
    public String transform(String text) {
        int characterNumber = text.length();
        return characterNumber == 1 ? characterNumber + " character" : characterNumber + " characters";
    }
}
