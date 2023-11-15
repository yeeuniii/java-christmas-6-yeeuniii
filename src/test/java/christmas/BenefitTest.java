package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BenefitTest {
    @DisplayName("크리스마스 당일날 크리스마스 디데이 할인가격 확인")
    @Test
    void getChristmasDDayDiscount() {
        Benefit benefit = new Benefit(new Date("25"));

        assertThat(benefit.applyChristmasDayDiscount()).isEqualTo(3400);
    }

    @DisplayName("크리스마스 지난 후 크리스마스 디데이 할인 적용 안됨")
    @Test
    void notApplyChristmasDayDiscount() {
        Benefit benefit = new Benefit(new Date("26"));

        assertThat(benefit.applyChristmasDayDiscount()).isEqualTo(0);
    }

    @DisplayName("평일인 경우 할인 가격 확인 및 주말 할인 적용 안됨")
    @ValueSource(strings = {"4", "7", "11", "14", "18", "31"})
    @ParameterizedTest
    void getWeekdayDiscount(String day) {
        Benefit benefit = new Benefit(new Date(day));

        assertThat(benefit.applyWeekdayDiscount(1)).isEqualTo(Benefit.WEEK_EVENT_PRICE);
        assertThat(benefit.applyWeekendDiscount(1)).isEqualTo(0);
    }

    @DisplayName("주말인 경우 할인 가격 확인 및 평일 할인 적용 안됨")
    @ValueSource(strings = {"1", "2", "8", "9", "15", "16", "22", "23", "29", "30"})
    @ParameterizedTest
    void getWeekendDiscount(String day) {
        Benefit benefit = new Benefit(new Date(day));

        assertThat(benefit.applyWeekdayDiscount(1)).isEqualTo(0);
        assertThat(benefit.applyWeekendDiscount(1)).isEqualTo(Benefit.WEEK_EVENT_PRICE);
        assertThat(benefit.applySpecialDiscount()).isEqualTo(0);
    }

    @DisplayName("특별 할인 적용 확인")
    @ValueSource(strings = {"3", "10", "17", "24", "25", "31"})
    @ParameterizedTest
    void getSpecialDiscount(String day) {
        Benefit benefit = new Benefit(new Date(day));

        assertThat(benefit.applySpecialDiscount()).isEqualTo(Benefit.SPECIAL_EVENT_PRICE);
        assertThat(benefit.applyWeekdayDiscount(1)).isEqualTo(Benefit.WEEK_EVENT_PRICE);
        assertThat(benefit.applyWeekendDiscount(1)).isEqualTo(0);
    }

    @DisplayName("개수에 따른 주말 할인 적용 확인")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void getWeekendDiscountByCount(int count) {
        Benefit benefit = new Benefit(new Date("1"));
        int result = benefit.applyWeekendDiscount(count);

        assertThat(result).isEqualTo(count * Benefit.WEEK_EVENT_PRICE);
    }
}
