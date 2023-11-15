package christmas;

public class Table {
    private static final int MINIMUM_ORDER_PRICE = 10000;
    private final Order order;
    private final Benefit benefit;
    private final int totalPrice;
    private int totalDiscountPrice;

    public Table(final Order order, final Benefit benefit) {
        this.order = order;
        this.benefit = benefit;
        this.totalPrice = order.calculateTotalPriceBeforeBenefit();
        this.totalDiscountPrice = 0;
    }

    public String getMenuList() {
        return order.makeMenuList();
    }

    public int getTotalPriceBeforeDiscount() {
        return this.totalPrice;
    }

    public int getTotalBenefitPrice() {
        int benefitPrice = this.totalDiscountPrice;

        if (benefit.isEnoughGiftEvent(totalPrice)) {
            benefitPrice += Benefit.GIFT_EVENT_MENU.getPriceByCount(1);
        }
        return benefitPrice;
    }

    public int getTotalPriceAfterDiscount() {
        return this.totalPrice - this.totalDiscountPrice;
    }

    public String getGiftMenu() {
        if (benefit.isEnoughGiftEvent(totalPrice)) {
            return Benefit.GIFT_EVENT_MENU.getName() + " 1개";
        }
        return Benefit.NONE;
    }

    public boolean startEvent() {
        return totalPrice >= MINIMUM_ORDER_PRICE;
    }

    public int getChristmasDayDiscount() {
        int discount = benefit.applyChristmasDayDiscount();

        totalDiscountPrice += discount;
        return discount;
    }

    public int getWeekdayDiscount() {
        int discount = benefit.applyWeekdayDiscount(order.getOrderNumberOfCategory(Category.MAIN));

        totalDiscountPrice += discount;
        return discount;
    }

    public int getWeekendDiscount() {
        int discount = benefit.applyWeekendDiscount(order.getOrderNumberOfCategory(Category.DESSERT));

        totalDiscountPrice += discount;
        return discount;
    }

    public int getSpecialDiscount() {
        int discount = benefit.applySpecialDiscount();

        totalDiscountPrice += discount;
        return discount;
    }

    public int getGiftBenefit() {
        return Benefit.GIFT_EVENT_MENU.getPriceByCount(1);
    }

    public String getBadge() {
        return Badge.getBadgeNameOfDiscount(getTotalBenefitPrice());
    }
}
