package christmas;

public class Benefit {
    public static final String GIFT_EVENT_MENU = "샴페인";
    private static final int GIFT_EVENT_PRICE = 120000;
    private static final int WEEK_EVENT_PRICE = 2023;
    private static final int SPECIAL_EVENT_PRICE = 1000;
    private final Date date;

    public Benefit(final Date date) {
        this.date = date;
    }

    public boolean isEnoughGiftEvent(final int price) {
        return price >= GIFT_EVENT_PRICE;
    }

    public int getChristmasDayDiscount() {
        if (date.isChristmasEvent()) {
            return 1000 + (date.getDay() - 1) * 100;
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
        return calculateDiscount(!date.isWeekend(), count);
    }

    public int getWeekendDiscount(final int count) {
        return calculateDiscount(date.isWeekend(), count);
    }

    public int getSpecialDiscount(final int count) {
        if (date.isEvent()) {
            return SPECIAL_EVENT_PRICE;
        }
        return 0;
    }
}
