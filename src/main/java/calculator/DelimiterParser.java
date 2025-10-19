package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = ":|,";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public String[] parse(String stringExpression) {
        if (hasCustomDelimiter(stringExpression)) {
            return parseCustomDelimiterExpression(stringExpression);
        }

        return stringExpression.split(DEFAULT_DELIMITER);
    }

    private boolean hasCustomDelimiter(String stringExpression) {
        return stringExpression.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String[] parseCustomDelimiterExpression(String stringExpression) {
        int endOfCustomDelimiter = stringExpression.lastIndexOf(CUSTOM_DELIMITER_SUFFIX);
        endOfCustomDelimiter += CUSTOM_DELIMITER_SUFFIX.length();

        String customDelimiterString = extractDelimiterString(stringExpression, endOfCustomDelimiter);
        String expression = extractExpression(stringExpression, endOfCustomDelimiter);

        String customDelimiterRegex = buildCustomDelimiterRegex(customDelimiterString);

        return expression.split(customDelimiterRegex);
    }

    private String extractDelimiterString(String expression, int endOfCustomDelimiter) {
        return expression.substring(0, endOfCustomDelimiter);
    }

    private String extractExpression(String expression, int endOfCustomDelimiter) {
        return expression.substring(endOfCustomDelimiter);
    }

    private String buildCustomDelimiterRegex(String customDelimiterString) {
        StringBuilder customDelimiterBuilder = new StringBuilder(DEFAULT_DELIMITER);
        String[] customDelimiterArray = customDelimiterString.split(CUSTOM_DELIMITER_SUFFIX);

        Arrays.stream(customDelimiterArray).forEach(delimiter -> {
            customDelimiterBuilder.append("|");
            customDelimiterBuilder.append(Pattern.quote(extractCustomDelimiter(delimiter)));
        });

        return customDelimiterBuilder.toString();
    }

    private String extractCustomDelimiter(String delimiterString) {
        int start = delimiterString.indexOf(CUSTOM_DELIMITER_PREFIX);
        start += CUSTOM_DELIMITER_PREFIX.length();

        return delimiterString.substring(start);
    }
}