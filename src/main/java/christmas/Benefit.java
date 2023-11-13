package christmas;

public class Benefit {
    public static final String GIFT_EVENT_MENU = "샴페인";
    private static final int GIFT_EVENT_PRICE = 120000;
    private static final int WEEK_EVENT_PRICE = 2023;
    private static final int SPECIAL_EVENT_PRICE = 1000;
    private final Date date;
    private int totalDiscount = 0;

    public Benefit(final Date date) {
        this.date = date;
    }

    public boolean isEnoughGiftEvent(final int price) {
        return price >= GIFT_EVENT_PRICE;
    }

    public int getChristmasDayDiscount() {
        if (date.isChristmasEvent()) {
            int discount = 1000 + (date.getDay() - 1) * 100;
            totalDiscount += discount;
            return discount;
        }
        return 0;
    }

    private int calculateDiscount(final boolean isDiscountedDay, final int count) {
        if (date.isEvent() && isDiscountedDay) {
            return count * WEEK_EVENT_PRICE;
        }
        return 0;
    }

    public int getWeekdayDiscount(final int count) {
        int discount = calculateDiscount(!date.isWeekend(), count);
        totalDiscount += discount;
        return discount;
    }

    public int getWeekendDiscount(final int count) {
        int discount = calculateDiscount(date.isWeekend(), count);
        totalDiscount += discount;
        return discount;
    }

    public int getSpecialDiscount() {
        if (date.isEvent()) {
            totalDiscount += SPECIAL_EVENT_PRICE;
            return SPECIAL_EVENT_PRICE;
        }
        return 0;
    }

    public int getTotalDiscount() {
        return this.totalDiscount;
    }
}
