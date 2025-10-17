package calculator;

public class DelimiterParser {
    private static final String DELIMITER = ":|,";

    public String[] parse(String stringExpression) {
        return stringExpression.split(DELIMITER);
    }
}
