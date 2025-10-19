package calculator;

public class OutputHandler {
    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printCalculateResult(int number) {
        System.out.println(RESULT_MESSAGE + number);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
