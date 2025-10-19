package calculator;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        CalculatorController calculatorController = new CalculatorController(calculator);
        calculatorController.start();
    }
}
