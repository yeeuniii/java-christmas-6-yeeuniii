package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BenefitTest {
    @DisplayName("크리스마스 당일날 크리스마스 디데이 할인가격 확인")
    @Test
    void getChristmasDDayDiscount() {
        Benefit benefit = new Benefit(new Date("25"));
        assertThat(benefit.getChristmasDayDiscount()).isEqualTo(3400);
    }

    @DisplayName("크리스마스 지난 후 크리스마스 디데이 할인 적용 안됨")
    @Test
    void notApplyChristmasDayDiscount() {
        Benefit benefit = new Benefit(new Date("26"));
        assertThat(benefit.getChristmasDayDiscount()).isEqualTo(0);
    }

    @DisplayName("평일인 경우 할인 가격 확인 및 주말 할인 적용 안됨")
    @Test
    void getWeekdayDiscount() {
        Benefit benefit = new Benefit(new Date("31"));
        assertThat(benefit.getWeekdayDiscount(1)).isEqualTo(2023);
        assertThat(benefit.getWeekendDiscount(1)).isEqualTo(0);
    }

    @DisplayName("주말인 경우 할인 가격 확인 및 평일 할인 적용 안됨")
    @Test
    void getWeekendDiscount() {
        Benefit benefit = new Benefit(new Date("30"));
        assertThat(benefit.getWeekdayDiscount(1)).isEqualTo(0);
        assertThat(benefit.getWeekendDiscount(1)).isEqualTo(2023);
    }
}
