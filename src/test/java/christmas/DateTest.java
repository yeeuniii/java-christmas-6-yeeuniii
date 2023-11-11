package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DateTest {
    @DisplayName("숫자가 아닌 문자열로 생성시 예외 반환 확인")
    @Test
    void createNonNumericDate() {
        assertThatThrownBy(() -> new Date("one"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("유효범위 날짜보다 작은 수의 날짜 생성시 예외 반환 확인")
    @Test
    void createUnderRangedDate() {
        assertThatThrownBy(() -> new Date("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("유효범위 날짜보다 큰 수의 날짜 생성시 예외 반환 확인")
    @Test
    void createOverRangedDate() {
        assertThatThrownBy(() -> new Date("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
