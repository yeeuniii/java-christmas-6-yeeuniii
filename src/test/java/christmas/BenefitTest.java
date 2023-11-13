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
}
