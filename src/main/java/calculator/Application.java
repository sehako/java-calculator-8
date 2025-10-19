package calculator;

public class Application {
    public static void main(String[] args) {
        DelimiterParser delimiterParser = new DelimiterParser();
        StringCalculator calculator = new StringCalculator(delimiterParser);
        CalculatorController calculatorController = new CalculatorController(calculator);
        calculatorController.start();
    }
}
