package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// prof. -> professor
// dr -> doctor
// e.g. -> for example
// aso -> and so on
// Preserves case: E.g. -> For example
public class ExpansionTransformer implements TextTransformer {
    static private class Expansion {
        final public String regex;
        final public List<String> replacements;

        private Expansion(String regex, String replacement) {
            this.regex = regex;
            this.replacements = Arrays.asList(replacement.split(" "));
        }
    }

    @Override
    public String transform(String text) {
        final List<Expansion> expansions = new ArrayList<>();
        expansions.add(new Expansion("(p)rof\\.", "professor"));
        expansions.add(new Expansion("(d)r", "doctor"));
        expansions.add(new Expansion("(e)\\.(g)\\.", "for example"));
        expansions.add(new Expansion("(a)(s)(o)", "and so on"));

        final List<Replacement> replacements = new ArrayList<>();
        for (Expansion expansion : expansions) {
            final Matcher matcher = Pattern.compile(expansion.regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE).matcher(text);

            while (matcher.find()) {
                StringBuilder replacement = new StringBuilder();

                boolean allUpper = true;
                for (char character : matcher.group(0).toCharArray())
                    if (Character.isLowerCase(character)) {
                        allUpper = false;
                        break;
                    }

                for (int i = 0; i < expansion.replacements.size(); i++) {
                    String word = expansion.replacements.get(i);

                    if (allUpper) {
                        replacement.append(word.toUpperCase());
                    } else if (Character.isLowerCase(matcher.group(i + 1).charAt(0))) {
                        replacement.append(word.toLowerCase());
                    } else {
                        replacement.append(Character.toUpperCase(word.charAt(0)));
                        replacement.append(word.substring(1));
                    }

                    if (i < expansion.replacements.size() - 1)
                        replacement.append(" ");
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
