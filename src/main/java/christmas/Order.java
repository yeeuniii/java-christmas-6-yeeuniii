package christmas;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Order {
    public static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final int MAXIMUM_ORDER_NUMBER = 20;
    private final List<Menu> menus = new ArrayList<>();

    public Order(final String[] menus) {
        for (String menu : menus) {
            receiveMenu(menu);
        }
        checkValidMenus();
     }

    private void receiveMenu(final String menu) {
        String[] info = menu.split("-");
        if (info.length != 2) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        menus.add(new Menu(info[0], info[1]));
    }

    private void checkValidMenus() {
        checkValidation(isDuplicatedMenu());
        checkValidation(hasOnlyDrink());
        if (exceedMaximumOrderNumber()) {
            processExceededMaximumOrderNumber();
        }
    }

    private void checkValidation(boolean isInvalid) {
        if (isInvalid) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private boolean isDuplicatedMenu() {
        HashSet<Menu> duplicated = new HashSet<>(menus);
        return duplicated.size() != menus.size();
    }

    private boolean hasOnlyDrink() {
        for (Menu menu : menus) {
            if (!menu.isDrink()) {
                return false;
            }
        }
        return true;
    }

    private void processExceededMaximumOrderNumber() {
        int count = 0;
        int index = 0;

        while (count < MAXIMUM_ORDER_NUMBER && index < menus.size()) {
            Menu menu = menus.get(index++);
            count += menu.getCount();
        }
        if (count > MAXIMUM_ORDER_NUMBER) {
            menus.get(index - 1).reduceCount(count - MAXIMUM_ORDER_NUMBER);
        }
        menus.subList(index, menus.size()).clear();
    }

    private boolean exceedMaximumOrderNumber() {
        return getTotalOrder() > MAXIMUM_ORDER_NUMBER;
    }

    private int getTotalOrder() {
        int total = 0;

        for (Menu menu : menus) {
            total += menu.getCount();
        }
        return total;
    }

    public String makeMenuList() {
        StringBuilder result = new StringBuilder();

        for (Menu menu : menus) {
            result.append(menu.getMenuAndCount());
            result.append("\n");
        }
        return result.toString();
    }

    public int calculateTotalPriceBeforeBenefit() {
        int total = 0;

        for (Menu menu : menus) {
            total += menu.getPrice();
        }
        return total;
    }

    public int getNumberOfMainMenu() {
        int count = 0;

        for (Menu menu : menus) {
            if (menu.isMain()) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfDessertMenu() {
        int count = 0;

        for (Menu menu : menus) {
            if (menu.isDessert()) {
                count++;
            }
        }
        return count;
    }
}
