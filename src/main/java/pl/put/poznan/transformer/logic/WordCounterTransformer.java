package pl.put.poznan.transformer.logic;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounterTransformer implements TextTransformer {
    @Override
    public String transform(String text) {
        Pattern pattern = Pattern.compile("(\\s|[!.,;?])+", Pattern.UNICODE_CASE + Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        List<MatchResult> results = matcher.results().collect(Collectors.toList());
        int wordNumber  = (int) results.size() + 1;
        if (!results.isEmpty() && results.get(0).start() == 0)
            wordNumber--;
        if (results.size() > 1 && results.get(results.size() - 1).end() == text.length())
            wordNumber--;
        return wordNumber == 1 ? wordNumber + " word" : wordNumber + " words";
    }
}
