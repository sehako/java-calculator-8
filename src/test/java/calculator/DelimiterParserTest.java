package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
}