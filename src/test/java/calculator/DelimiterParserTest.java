package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {
    @Test
    @DisplayName("사용자가 입력된 기본 구분자를 가진 수식을 문장 배열로 분리한다.")
    public void basicParserTest() {
        // given
        String expression = "1,2:3";

        // when
        String[] result = DelimiterParser.parse(expression);

        // then

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }
}