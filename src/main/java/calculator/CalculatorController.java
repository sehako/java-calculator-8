package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final StringCalculator calculator;

    public CalculatorController(StringCalculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        OutputHandler.printGuideMessage();
        String input = Console.readLine();
        try {
            int result = calculator.calculate(input);
            OutputHandler.printCalculateResult(result);
        } catch (IllegalArgumentException e) {
            OutputHandler.printErrorMessage(e.getMessage());
        }
    }
}
