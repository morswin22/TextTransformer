package pl.put.poznan.transformer.logic;

import java.util.HashMap;

public class NumberTransformer extends TextTransformer {

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
        String[] words = text.split(" ", -1);

        for (String word : words) {
            try {
                double number = Double.parseDouble(word);
                if(number < 0) {
                    sb.append("minus ");
                    number = -number;
                }

                double floatingPoint = (number - Math.floor(number)) * 100;

                sb.append(numberToText((int) number)).append(floatingPointToString((int) floatingPoint)).append(" ");
            } catch (NumberFormatException e) {
                sb.append(word).append(" ");
            }
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

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

