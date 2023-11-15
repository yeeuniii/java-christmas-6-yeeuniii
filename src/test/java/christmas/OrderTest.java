package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @DisplayName("잘못된 형식의 주문 들어온 경우 예외 처리")
    @Test
    void createInvalidFormatOrder() {
        String[] menu = {"1", "레드와인"};
        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }

    @DisplayName("잘못된 이름의 주문 들어온 경우 예외 처리")
    @Test
    void createInvalidNameOrder() {
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

    @DisplayName("할인 전 총 주문 금액 계산")
    @Test
    void calculateTotalOrderPriceBeforeSale() {
        String[] menus = {"티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"};
        Order order = new Order(menus);
        int result  = order.calculateTotalPriceBeforeBenefit();

        assertThat(result).isEqualTo(142000);
    }

    @DisplayName("메인, 디저트 메뉴 수 구하기")
    @Test
    void getNumberOfMainMenu() {
        String[] menus = {"티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"};
        Order order = new Order(menus);

        assertThat(order.getOrderNumberOfCategory(Category.MAIN)).isEqualTo(2);
        assertThat(order.getOrderNumberOfCategory(Category.DESSERT)).isEqualTo(2);
    }

    @DisplayName("20개 이상의 메뉴 주문했을 때 처리(최대 주문수를 초과했을 때, 수가 딱 맞아 떨어지는 경우)")
    @Test
    void exceedMaximumOrderNumber() {
        String[] menus = {"티본스테이크-10", "바비큐립-9", "초코케이크-1", "제로콜라-1"};
        Order order = new Order(menus);
        String result = order.makeMenuList();

        assertThat(result).isEqualTo("티본스테이크 10개\n바비큐립 9개\n초코케이크 1개\n");
    }

    @DisplayName("20개 이상의 메뉴 주문했을 때 처리(최대 주문수를 초과했을 때, 수가 딱 맞아 떨어지지 않는 경우)")
    @Test
    void exceedMaximumOrderNumberAndSetCount() {
        String[] menus = {"티본스테이크-10", "바비큐립-9", "초코케이크-7", "제로콜라-1"};
        Order order = new Order(menus);
        String result = order.makeMenuList();

        assertThat(result).isEqualTo("티본스테이크 10개\n바비큐립 9개\n초코케이크 1개\n");
    }

    @DisplayName("20개 이상의 메뉴 주문했는데 중복있는 경우 예외 처리")
    @Test
    void exceedMaximumOrderNumberButDuplicated() {
        String[] menus = {"티본스테이크-10", "바비큐립-9", "초코케이크-1", "제로콜라-1", "바비큐립-1"};

        assertThatThrownBy(() -> new Order(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }

    @DisplayName("20개 이상의 메뉴 주문했는데 형식이 잘못된 경우 예외 처리")
    @Test
    void exceedMaximumOrderNumberButInvalidFormat() {
        String[] menus = {"티본스테이크-10", "바비큐립-9", "초코케이크-1", "제로콜라-1", "바비큐 립-1"};

        assertThatThrownBy(() -> new Order(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }
}
