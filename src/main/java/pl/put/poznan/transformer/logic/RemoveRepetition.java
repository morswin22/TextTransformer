package pl.put.poznan.transformer.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveRepetition implements TextTransformer {
    @Override
    public String transform(String text) {
        StringBuilder reviewedText = new StringBuilder();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.MULTILINE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(text);
        String previousWord = "";
        int x = 0;
        while (matcher.find()) {
            String word = matcher.group();
            if (!previousWord.equals(word)) {
                reviewedText.append(text, x, matcher.end());
            }
            x = matcher.end();
            previousWord = word;
        }
        reviewedText.append(text.substring(x));
        return reviewedText.toString();
    }
}
