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

    @DisplayName("크리스마스 디데이와 다른 이벤트 기간에 해당하는지 확인")
    @ValueSource(strings = {"1", "10", "25"})
    @ParameterizedTest
    void isChristmasEventDay(String day) {
        Date date = new Date(day);

        assertThat(date.isChristmasEvent()).isTrue();
        assertThat(date.isEvent()).isTrue();
    }

    @DisplayName("크리스마스 디데이에는 해당하지 않지만, 다른 이벤트에는 해당하는지 확인")
    @ValueSource(strings = {"26", "30", "31"})
    @ParameterizedTest
    void isNotChristmasEventButIncludingOhterEventDay(String day) {
        Date date = new Date(day);

        assertThat(date.isChristmasEvent()).isFalse();
        assertThat(date.isEvent()).isTrue();
    }

    @DisplayName("평일인지 확인")
    @ValueSource(strings = {"5", "13", "25"})
    @ParameterizedTest
    void isWeekday(String day) {
        Date date = new Date(day);

        assertThat(date.isWeekend()).isFalse();
    }
}
