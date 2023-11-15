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

    @DisplayName("equals 메서드 오버라이딩 확인")
    @Test
    void checkEquals() {
        Menu menu = new Menu("양송이수프", "3");

        boolean result = menu.equals(new Menu("양송이수프", "4"));
        assertThat(result).isTrue();
    }

    @DisplayName("main 메뉴인 경우, 개수 반환")
    @ValueSource(strings = {"티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"})
    @ParameterizedTest
    void getMainMenuCount(String menuName) {
        Menu menu = new Menu(menuName, "3");
        int result = menu.getCountOfCategory(Category.MAIN);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("main 메뉴 아닌 경우, 0 반환")
    @ValueSource(strings = {"양송이수프", "타파스", "시저샐러드", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"})
    @ParameterizedTest
    void getNonMainMenuCount(String menuName) {
        Menu menu = new Menu(menuName, "3");
        int result = menu.getCountOfCategory(Category.MAIN);

        assertThat(result).isEqualTo(0);
    }
}
