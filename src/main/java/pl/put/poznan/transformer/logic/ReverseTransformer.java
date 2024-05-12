package pl.put.poznan.transformer.logic;

public class ReverseTransformer implements TextTransformer
{
    @Override
    public String transform(String text) {
        int[] cases = new int[text.length()];
        int[] casesR = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                cases[i] = 1;
            } else {
                cases[i] = 0;
            }
        }

        for (int i = 0, j = cases.length - 1; i < cases.length; i++, j--) {
            casesR[i] = cases[i] - cases[j];
        }

        StringBuilder transformedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int shift = casesR[i] * 32;
            transformedText.append((char)(letter + shift));
        }

        return transformedText.reverse().toString();
    }
}
