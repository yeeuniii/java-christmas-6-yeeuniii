package christmas;

import java.text.DecimalFormat;

public class OutputView {
    public static void displayEventPlanner(final Order order) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(order.getAllMenuList());
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(convertFormat(order.calculateTotalPriceBeforeBenefit()) + "원");
    }

    private static String convertFormat(final int message) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(message);
    }
}
