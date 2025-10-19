package calculator;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final Pattern ONLY_DIGITS = Pattern.compile("^[0-9]+$");
    private static final Pattern HAS_WHITESPACE = Pattern.compile(".*\\s+.*");

    public static void validate(String[] numbers) {
        for (String number : numbers) {
            if (number.isBlank() || HAS_WHITESPACE.matcher(number).matches()) {
                throw new IllegalArgumentException("수식에 공백이 존재합니다.");
            }

            if (number.startsWith("-")) {
                throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
            }

            if (!ONLY_DIGITS.matcher(number).matches()) {
                throw new IllegalArgumentException("숫자 이외에 문자, 지정되지 않은 구분자, 중복 구분자가 존재합니다.");
            }
        }
    }
}
