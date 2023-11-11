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

    public boolean equals(final String name) {
        return this.menu.equals(name);
    }
}
