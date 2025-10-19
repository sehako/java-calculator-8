package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator(new DelimiterParser());

    @Test
    @DisplayName("사용자가 기본 구분자가 존재하는 수식을 입력하면 입력된 숫자를 기반으로 합을 구한다.")
    public void validExpressionTest() {
        // given
        String expression = "3,4:5";

        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("사용자가 커스텀 구분자를 지정하면 커스텀 구분자와 입력된 숫자를 기반으로 합을 구한다.")
    public void validCustomDelimiterExpressionTest() {
        // given
        String expression = "//;\n3,4;5";

        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("사용자가 아무런 수식을 입력하지 않거나 공백만 입력하면 계산 결과가 0이 된다.")
    public void blankExpressionTest() {
        // given
        String expression = "          ";

        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }
}