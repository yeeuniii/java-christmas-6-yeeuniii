package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuInformationTest {
    @DisplayName("메뉴 리스트에 일치하는 이름 있는 경우 value 반환")
    @Test
    void createMatchingMenuInformation() {
        MenuInformation menu = MenuInformation.getMenuByName("해산물파스타");

        assertThat(menu).isEqualTo(MenuInformation.SEAFOOD_PASTA);
    }

    @DisplayName("메뉴 리스트에 일치하는 이름 없는 경우 null 반환")
    @Test
    void createNonMatchingMenuInformation() {
        MenuInformation menu = MenuInformation.getMenuByName("해산물 파스타");

        assertThat(menu).isNull();
    }

    @DisplayName("음료 메뉴인지 확인하는 함수")
    @Test
    void isDrink() {
        MenuInformation menu = MenuInformation.RED_WINE;

        assertThat(menu.isDrink()).isTrue();
    }
}
