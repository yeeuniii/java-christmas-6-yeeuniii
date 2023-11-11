package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
    @DisplayName("존재하지 않는 메뉴 생성시 예외 반환")
    @Test
    void createNotExistenceMenu() {
        assertThatThrownBy(() -> new Menu("양송이스프", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }

    @DisplayName("0개의 메뉴 셍성시 예외 반환")
    @Test
    void createZeroCountMenu() {
        assertThatThrownBy(() -> new Menu("양송이수프", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }

    @DisplayName("정상적인 메뉴 확인")
    @Test
    void createMenu() {
        Menu menu = new Menu("양송이수프", "3");

        assertThat(menu).isInstanceOf(Menu.class);
    }
}
