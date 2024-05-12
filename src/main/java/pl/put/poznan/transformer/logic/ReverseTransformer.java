package pl.put.poznan.transformer.logic;

public class ReverseTransformer implements TextTransformer
{
    @Override
    public String transform(String text) {
        int[] cases = new int[text.length()];
        int[] casesR = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (Character.isUpperCase(letter)) {
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
            if (casesR[i] == 1) {
                transformedText.append(Character.toUpperCase(letter));
            }
            else if (casesR[i] == -1) {
                transformedText.append(Character.toLowerCase(letter));
            }
            else {
                transformedText.append(letter);
            }
        }

        return transformedText.reverse().toString();
    }
}
