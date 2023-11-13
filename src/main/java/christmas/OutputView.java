package christmas;

import java.text.DecimalFormat;

public class OutputView {
    private static final String NONE_MESSAGE = "없음";
    private static int totalPrice;

    public static void displayEventPlanner(final Order order, final Benefit benefit) {
        totalPrice = order.calculateTotalPriceBeforeBenefit();

        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(order.getAllMenuList());
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(convertFormat(totalPrice) + "원");
        System.out.println("\n<증정 메뉴>");
        System.out.println(getGiftMenuMessage(benefit));
    }

    private static String getGiftMenuMessage(final Benefit benefit) {
        if (benefit.isEnoughGiftEvent(totalPrice)) {
            return Benefit.GIFT_EVENT_MENU + " 1개";
        }
        return NONE_MESSAGE;
    }

    private static String convertFormat(final int message) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(message);
    }
}
