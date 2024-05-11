package pl.put.poznan.transformer.logic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTransformer implements TextTransformer
{

    private final HashMap<Integer, String> numberToText = new HashMap<Integer, String>() {{
        put(0, "zero"); put(1, "one"); put(2, "two"); put(3, "three");
        put(4, "four"); put(5, "five"); put(6, "six"); put(7, "seven");
        put(8, "eight"); put(9, "nine"); put(10, "ten"); put(11, "eleven");
        put(12, "twelve"); put(13, "thirteen"); put(14, "fourteen"); put(15, "fifteen");
        put(16, "sixteen"); put(17, "seventeen"); put(18, "eighteen"); put(19, "nineteen");
        put(20, "twenty"); put(30, "thirty"); put(40, "forty"); put(50, "fifty");
        put(60, "sixty"); put(70, "seventy"); put(80, "eighty"); put(90, "ninety");
        put(100, "hundred"); put(1000, "thousand");
    }};

    @Override
    public String transform(String text) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(\\d+)(\\.(\\d+))?", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        int currentIndex = 0;

        while (matcher.find()) {
            sb.append(text, currentIndex, matcher.start());
            currentIndex = matcher.end();
            try {
                BigDecimal number = new BigDecimal((matcher.group()));

                int floatingPoint = number.subtract(new BigDecimal(number.intValue())).movePointRight(2).intValue();


                sb.append(numberToText(number.intValue())).append(floatingPointToString(floatingPoint));
            } catch (NumberFormatException e) {
                sb.append(matcher.group());
            }
        }

        sb.append(text, currentIndex, text.length());

        return sb.toString();
    }

    private String numberToText(int number) {
        if (number < 20) {
            return numberToText.get(number);
        } else if (number < 100) {
            return wholeNumberToString(number, 10);
        } else if (number < 1000) {
            return wholeNumberToString(number, 100);
        } else if (number < 10000) {
            return wholeNumberToString(number, 1000);
        } else {
            throw new NumberFormatException("Number too large");
        }
    }

    private String wholeNumberToString(int number, int multiplier) {
        String result;
        if (multiplier == 10) {
            result =  numberToText.get(number - number % multiplier);
        }
        else {
            result = numberToText.get(number / multiplier) + " " + numberToText.get(multiplier);
        }

        if (number % multiplier != 0) {
            result += " " + numberToText(number % multiplier);
        }

        return result;
    }

    private String floatingPointToString(int number) {
        String result = "";
        if (number != 0) {
            result = " and ";
            if (number % 10 == 0) {
                result += numberToText(number / 10) + " tenths";
            } else {
                result += numberToText(number) + " hundredths";
            }
        }

        if (number == 1 || number == 10) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

}

