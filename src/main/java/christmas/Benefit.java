package christmas;

public class Benefit {
    private static final int GIFT_EVENT_PRICE = 120000;
    private Date date;

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
}
