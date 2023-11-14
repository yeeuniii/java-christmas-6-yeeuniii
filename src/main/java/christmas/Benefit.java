package christmas;

public class Benefit {
    public static final MenuInformation GIFT_EVENT_MENU = MenuInformation.CHAMPAGNE;
    public static final String NONE = "없음";
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

    public int applyChristmasDayDiscount() {
        if (date.isChristmasEvent()) {
            return  1000 + (date.getDay() - 1) * 100;
        }
        return 0;
    }

    private int calculateDiscount(final boolean isDiscountedDay, final int count) {
        if (date.isEvent() && isDiscountedDay) {
            return count * WEEK_EVENT_PRICE;
        }
        return 0;
    }

    public int applyWeekdayDiscount(final int count) {
        return calculateDiscount(!date.isWeekend(), count);
    }

    public int applyWeekendDiscount(final int count) {
        return calculateDiscount(date.isWeekend(), count);
    }

    public int applySpecialDiscount() {
        if (date.isEvent()) {
            return SPECIAL_EVENT_PRICE;
        }
        return 0;
    }
}
