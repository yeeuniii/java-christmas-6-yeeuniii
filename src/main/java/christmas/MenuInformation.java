package christmas;

public enum MenuInformation {
    MUSHROOM_SOUP("양송이수프", 6000, Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),
    T_BONE_STAKE("티본스테이크", 55000, Category.MAIN),
    BARBCUE_RIBS("바비큐립", 54000, Category.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT),
    ZERO_COKE("제로콜라", 3000, Category.DRINK),
    RED_WINE("레드와인", 60000, Category.DRINK),
    CHAMPAGNE("샴페인", 25000, Category.DRINK);


    private final String name;
    private final int price;
    private final Category category;

    MenuInformation(final String name, final int price, final Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static MenuInformation getMenuByName(final String name) {
        for (MenuInformation menu : MenuInformation.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public boolean isDrink() {
        return category == Category.DRINK;
    }

    public String getMessageCombinedMenuAndCount(final int count) {
        return name + " " + count + "개";
    }

    public int getPriceByCount(final int count) {
        return price * count;
    }
}
