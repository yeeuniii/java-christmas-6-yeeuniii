package christmas;

import java.util.List;
import java.util.ArrayList;

public class Order {
    public static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final List<Menu> menus = new ArrayList<>();

    public Order(final String[] menus) {
        for (String menu : menus) {
            addMenu(menu);
        }
    }

    private void addMenu(final String menu) {
        String[] info = menu.split("-");
        if (info.length != 2) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + "format");
        }
        checkDuplicated(info[0]);
        this.menus.add(new Menu(info[0], info[1]));
    }

    private void checkDuplicated(final String menuName) {
        if (isDuplicatedMenu(menuName)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + "duplicated");
        }
    }

    private boolean isDuplicatedMenu(final String menuName) {
        for (Menu menu : menus) {
            if (menu.equals(menuName)) {
                return true;
            }
        }
        return false;
    }
}
