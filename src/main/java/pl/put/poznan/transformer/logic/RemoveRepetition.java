package pl.put.poznan.transformer.logic;

public class RemoveRepetition {
    public String removeRepetition(String text) {
        String previous_word = "";
        StringBuilder reviewedText = new StringBuilder();
        for (String word : text.split(" ")) {
            if (!previous_word.equals(word)) {
                reviewedText.append(word).append(" ");
            }
            previous_word = word;
        }
        return reviewedText.toString();
    }
}
