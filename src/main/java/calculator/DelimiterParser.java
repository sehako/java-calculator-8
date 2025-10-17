package calculator;

public class DelimiterParser {
    private static final String DELIMITER = ":|,";

    public static String[] parse(String stringExpression) {
        return stringExpression.split(DELIMITER);
    }
}
