package christmas;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Order {
    public static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final List<Menu> menus = new ArrayList<>();

    public Order(final String[] menus) {
        for (String menu : menus) {
            addMenu(menu);
        }
        checkValidMenus();
    }

    private void addMenu(final String menu) {
        String[] info = menu.split("-");
        if (info.length != 2) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.menus.add(new Menu(info[0], info[1]));
    }

    private void checkValidMenus() {
        checkDuplicated();
    }

    private void checkDuplicated() {
        if (isDuplicatedMenu()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private boolean isDuplicatedMenu() {
        HashSet<Menu> duplicated = new HashSet<>(menus);
        return duplicated.size() != menus.size();
    }
}
