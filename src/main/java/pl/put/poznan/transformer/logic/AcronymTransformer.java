package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

// Acronym expansion: for example -> e.g.
// Acronym expansion: among others -> i.a.
// Acronym expansion: and so on -> aso
// Works regardless of case
public class AcronymTransformer implements TextTransformer {
    static private class Acronym {
        final public String regex;
        final public List<Character> replacements;
        final public boolean hasDots;

        private Acronym(String regex, String replacements, boolean hasDots) {
            this.regex = regex;
            this.replacements = replacements.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            this.hasDots = hasDots;
        }
    }

    static private class Replacement {
        final public String replacement;
        final public int start;
        final public int end;

        private Replacement(String replacement, int start, int end) {
            this.replacement = replacement;
            this.start = start;
            this.end = end;
        }
    }

    @Override
    public String transform(String text) {
        final List<Acronym> acronyms = new ArrayList<>();
        acronyms.add(new Acronym("(f)or (e)xample", "eg", true));
        acronyms.add(new Acronym("(a)mong (o)thers", "ia", true));
        acronyms.add(new Acronym("(a)nd (s)o (o)n", "aso", false));

        final List<Replacement> replacements = new ArrayList<>();
        for (Acronym acronym : acronyms) {
            final Matcher matcher = Pattern.compile(acronym.regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE).matcher(text);

            while (matcher.find()) {
                StringBuilder replacement = new StringBuilder();
                for (int i = 0; i < acronym.replacements.size(); i++) {
                    char character = acronym.replacements.get(i);

                    if (Character.isLowerCase(matcher.group(i + 1).charAt(0))) {
                        replacement.append(Character.toLowerCase(character));
                    } else {
                        replacement.append(Character.toUpperCase(character));
                    }

                    if (acronym.hasDots) {
                        replacement.append(".");
                    }
                }
                replacements.add(0, new Replacement(replacement.toString(), matcher.start(), matcher.end()));
            }
        }

        StringBuilder textBuilder = new StringBuilder(text);
        for (Replacement replacement : replacements)
            textBuilder.replace(replacement.start, replacement.end, replacement.replacement);

        return textBuilder.toString();
    }
}
