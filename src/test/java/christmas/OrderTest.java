package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    @DisplayName("잘못된 형식의 주문 들어온 경우 예외 처리")
    @Test
    void createInvalidFormatOrder() {
        String[] menu = {"양송이스프-3", "레드와인-1"};
        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }
}
