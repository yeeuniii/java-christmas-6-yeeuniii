package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class DateTest {
    @DisplayName("숫자가 아닌 문자열로 날짜 생성시 예외 반환")
    @ValueSource(strings = {"양송이스프", "one", "asdf"})
    @ParameterizedTest
    void createNonNumericDate(String day) {
        assertThatThrownBy(() -> new Date(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Date.EXCEPTION_MESSAGE);
    }

    @DisplayName("유효한 범위가 아닌 날짜 생성시 예외 반환")
    @ValueSource(strings = {"32", "0", "-1"})
    @ParameterizedTest
    void createUnderRangedDate(String day) {
        assertThatThrownBy(() -> new Date(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Date.EXCEPTION_MESSAGE);
    }

    @DisplayName("유효한 범위 날짜 생성 확인")
    @ValueSource(strings = {"1", "15", "31"})
    @ParameterizedTest
    void createValidRangeDate(String day) {
        Date date = new Date(day);

        assertThat(date).isInstanceOf(Date.class);
    }
}
