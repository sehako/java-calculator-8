package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    @DisplayName("정상적인 숫자일 때에는 오류가 발생하지 않는다.")
    public void numbersValidTest() {
        // given
        String[] numbers = {"1", "2", "3"};

        // when
        // then
        assertDoesNotThrow(() -> NumberValidator.validate(numbers));
    }

    @Test
    @DisplayName("숫자에 공백이 존재하면 오류가 발생한다.")
    public void numberBlankTest() {
        // given
        String[] numbers = {"1", " 2", "3"};

        // when
        // then
        assertInvalidNumbers(
                numbers,
                "수식에 공백이 존재합니다."
        );
    }

    @Test
    @DisplayName("숫자에 음수가 존재하면 오류가 발생한다.")
    public void negativeNumberTest() {
        // given
        String[] numbers = {"-1", "-2", "-3"};

        // when
        // then
        assertInvalidNumbers(
                numbers,
                "음수는 계산할 수 없습니다."
        );
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 존재하면 오류가 발생한다.")
    public void NotNumberTest() {
        // given
        String[] numbers = {"1", "w2", "3"};

        // when
        // then
        assertInvalidNumbers(
                numbers,
                "숫자 이외에 문자, 지정되지 않은 구분자, 중복 구분자가 존재합니다."
        );
    }

    private void assertInvalidNumbers(String[] numbers, String expectedMessage) {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberValidator.validate(numbers),
                expectedMessage
        );
    }
}