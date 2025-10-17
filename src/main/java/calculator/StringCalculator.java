package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    public void start() {
        OutputHandler.printGuideMessage();
        String input = Console.readLine();
        int result = calculate(input);
        OutputHandler.printCalculateResult(result);
    }

    private int calculate(String input) {
        return 0;
    }
}
