package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {
    DelimiterParser parser = new DelimiterParser();

    @Test
    @DisplayName("사용자가 입력된 기본 구분자를 가진 수식을 문장 배열로 분리한다.")
    public void basicParserTest() {
        // given
        String expression = "1,2:3";

        // when
        String[] result = parser.parse(expression);

        // then

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("사용자가 커스텀 구분자를 입력하면 이를 기본 구분자에 포함하여 숫자를 추출한다.")
    public void customParserTest() {
        // given
        String expression = "//;\n//w\n1w2;3";

        // when
        String[] result = parser.parse(expression);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("사용자가 아무런 입력도 하지 않거나 커스텀 구분자만 지정한다면 추출되는 숫자는 없다.")
    public void blankInputTest() {
        // given
//        String expression = "      ";
        String expression = "//;\n          ";

        // when
        String[] result = parser.parse(expression);

        // then
        assertArrayEquals(new String[]{}, result);
    }

    @Test
    @DisplayName("사용자가 구분자 선언문을 잘못 입력하면 오륙가 발생한다.")
    public void invalidCustomDelimiterInputTest() {
        // given
        String expression = "/;\n//w\n1w2;3";

        // when
        // then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse(expression));
    }
}