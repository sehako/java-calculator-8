package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final DelimiterParser delimiterParser;

    public StringCalculator(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public int calculate(String input) {
        String[] numbers = delimiterParser.parse(input);
        NumberValidator.validate(numbers);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
