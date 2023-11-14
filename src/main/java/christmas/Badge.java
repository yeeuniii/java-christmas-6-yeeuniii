package christmas;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int price;

    Badge(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static String getBadgeNameOfDiscount(final int discount) {
        String name = "없음";

        for (Badge badge : Badge.values()) {
            if (badge.price > discount) {
                return name;
            }
            name = badge.name;
        }
        return name;
    }
}
