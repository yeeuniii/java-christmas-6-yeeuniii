package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @DisplayName("존재하지 않는 메뉴 생성시 예외 반환")
    @ValueSource(strings = {"양송이스프", "초코 케이크"})
    @ParameterizedTest
    void createNotExistenceMenu(String name) {
        assertThatThrownBy(() -> new Menu(name, "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Order.EXCEPTION_MESSAGE);
    }

    @DisplayName("잘못된 형식의 메뉴 셍성시 예외 반환")
    @ValueSource(strings = {"0", "asdf"})
    @ParameterizedTest
    void createZeroCountMenu(String count) {
        assertThatThrownBy(() -> new Menu("양송이수프", count))
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
