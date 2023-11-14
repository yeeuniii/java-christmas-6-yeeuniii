package christmas;

public class Menu {
    private MenuInformation menu;
    private int count;

    public Menu(final String name, final String count) {
        initMenu(name);
        initCount(count);
    }

    private void initMenu(final String name) {
        this.menu = MenuInformation.getMenuByName(name);
        if (this.menu == null) {
            throw new IllegalArgumentException(Order.EXCEPTION_MESSAGE);
        }
    }

    private void initCount(final String count) {
        checkCount(count);
        this.count = Integer.parseInt(count);
    }

    private void checkCount(final String count) {
        if (isInvalidCount(count)) {
            throw new IllegalArgumentException(Order.EXCEPTION_MESSAGE);
        }
    }

    private boolean isInvalidCount(final String count) {
        return !count.matches("[1-9]\\d*");
    }

    public boolean isMain() {
        return menu.isMain();
    }

    public boolean isDessert() {
        return menu.isDessert();
    }

    public boolean isDrink() {
        return menu.isDrink();
    }

    public String getMenuAndCount() {
        return menu.makeMessageCombinedMenuAndCount(count);
    }

    public int getPrice() {
        return menu.getPriceByCount(count);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return this.menu.equals(((Menu)other).menu);
    }

    @Override
    public int hashCode() {
        if (menu == null) {
            return 0;
        }
        return menu.hashCode();
    }
}
