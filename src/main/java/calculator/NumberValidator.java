package calculator;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final Pattern ONLY_DIGITS = Pattern.compile("^[0-9]+$");
    private static final Pattern HAS_WHITESPACE = Pattern.compile(".*\\s+.*");

    public static void validate(String[] numbers) {
        for (String number : numbers) {
            if (number.isBlank() || HAS_WHITESPACE.matcher(number).matches()) {
                throw new IllegalArgumentException();
            }

            if (number.startsWith("-")) {
                throw new IllegalArgumentException();
            }

            if (!ONLY_DIGITS.matcher(number).matches()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
