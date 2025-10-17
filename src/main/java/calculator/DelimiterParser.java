package calculator;

import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = ":|,";

    public String[] parse(String stringExpression) {
        if (hasCustomDelimiter(stringExpression)) {
            return parseCustomDelimiterExpression(stringExpression);
        }
        return stringExpression.split(DEFAULT_DELIMITER);
    }

    private boolean hasCustomDelimiter(String stringExpression) {
        return stringExpression.startsWith("//");
    }

    private String[] parseCustomDelimiterExpression(String stringExpression) {
        String[] lines = stringExpression.split("\n");

        StringBuilder delimiterBuilder = new StringBuilder(DEFAULT_DELIMITER);
        StringBuilder expressionBuilder = new StringBuilder();

        for (String line : lines) {
            appendDelimiter(delimiterBuilder, line);
            extractExpression(expressionBuilder, line);
        }

        String expression = expressionBuilder.toString();
        String delimiter = delimiterBuilder.toString();

        return expression.split(delimiter);
    }


    private void appendDelimiter(StringBuilder delimiterBuilder, String customDelimiterString) {
        if (!hasCustomDelimiter(customDelimiterString)) {
            return;
        }

        String delimiter = extractCustomDelimiter(customDelimiterString);

        delimiterBuilder.append("|");
        delimiterBuilder.append(Pattern.quote(delimiter));
    }

    private void extractExpression(StringBuilder expressionBuilder, String expression) {
        if (hasCustomDelimiter(expression)) {
            return;
        }

        expressionBuilder.append(expression);
    }

    private String extractCustomDelimiter(String delimiter) {
        return delimiter.substring(2);
    }
}
