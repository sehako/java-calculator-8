package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final DelimiterParser delimiterParser;

    public StringCalculator(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public int calculate(String input) {
        String[] numbers = delimiterParser.parse(input);

        return Arrays.stream(numbers)
                .peek(NumberValidator::validate)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
