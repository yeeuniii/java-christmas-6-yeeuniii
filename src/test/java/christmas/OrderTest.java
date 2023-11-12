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

    @DisplayName("중복된 주문 들어온 경우 예외 처리")
    @Test
    void createDuplicatedOrder() {
        String[] menu = {"양송이수프-3", "양송이수프-1"};
        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }

    @DisplayName("음료 주문 들어온 경우 예외 처리")
    @Test
    void createOnlyDrinkOrder() {
        String[] menu = {"제로콜라-3", "샴페인-1", "레드와인-2"};
        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }
}