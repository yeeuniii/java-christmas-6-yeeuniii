package christmas;

import java.text.DecimalFormat;

public class OutputView {
    private static final String NONE_MESSAGE = "없음";
    private static final String WON = "원";
    private static int totalPrice;

    public static void displayEventPlanner(final Order order, final Benefit benefit) {
        totalPrice = order.calculateTotalPriceBeforeBenefit();

        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(order.getAllMenuList());
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(makePriceMessage(totalPrice));
        System.out.println("\n<증정 메뉴>");
        System.out.println(makeGiftMenuMessage(benefit));
        System.out.println("\n<헤택 내역>");
        System.out.println(makeAllDiscountMessage(order, benefit));
        System.out.println("<총헤택 금액>");
        System.out.println(makeTotalDiscountPriceMessage(benefit));
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(makePriceMessage(order.calculateTotalPriceBeforeBenefit() - benefit.getTotalDiscount()));
    }

    private static String makeGiftMenuMessage(final Benefit benefit) {
        if (benefit.isEnoughGiftEvent(totalPrice)) {
            return Benefit.GIFT_EVENT_MENU + " 1개";
        }
        return NONE_MESSAGE;
    }

    private static String makeAllDiscountMessage(final Order order, final Benefit benefit) {
        String message;

        if (!benefit.isEnoughGiftEvent(totalPrice)) {
            return NONE_MESSAGE;
        }
        message = makeDiscountMessage("크리스마스 디데이 할인", benefit.getChristmasDayDiscount());
        message += makeDiscountMessage("평일 할인", benefit.getWeekdayDiscount(order.getNumberOfMainMenu()));
        message += makeDiscountMessage("주말 할인", benefit.getWeekendDiscount(order.getNumberOfDessertMenu()));
        message += makeDiscountMessage("특별 할인", benefit.getSpecialDiscount());
        message += makeDiscountMessage("증정 이벤트", MenuInformation.CHAMPAGNE.getPriceByCount(1));
        return message;
    }

    private static String makeDiscountMessage(final String discountType, final int discountPrice) {
        if (discountPrice == 0) {
            return "";
        }
        return discountType + ": " + makePriceMessage(discountPrice * -1) + "\n";
    }

    private static String makeTotalDiscountPriceMessage(final Benefit benefit) {
        int totalDiscount = benefit.getTotalDiscount();

        if (benefit.isEnoughGiftEvent(totalPrice)) {
            totalDiscount += MenuInformation.CHAMPAGNE.getPriceByCount(1);
        }
        return makePriceMessage(totalDiscount * -1);
    }

    private static String makePriceMessage(final int price) {
        return convertFormat(price) + WON;
    }

    private static String convertFormat(final int message) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(message);
    }
}
