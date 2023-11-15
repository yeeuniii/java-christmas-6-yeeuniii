package christmas;

import java.text.DecimalFormat;
import java.util.Objects;

public class OutputView {
    private static final String NONE_MESSAGE = "없음";
    private static final String WON = "원";

    public static void displayEventPlanner(final Table table) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(table.getMenuList());
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(makePriceMessage(table.getTotalPriceBeforeDiscount()));
        System.out.println("<증정 메뉴>");
        System.out.println(table.getGiftMenu() + "\n");
        System.out.println("<혜택 내역>");
        System.out.println(makeAllDiscountMessage(table));
        System.out.println("<총혜택 금액>");
        System.out.println(makePriceMessage(table.getTotalBenefitPrice() * -1));
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(makePriceMessage(table.getTotalPriceAfterDiscount()));
        System.out.println("<12월 이벤트 배지>");
        System.out.println(table.getBadge());
    }

    private static String makeAllDiscountMessage(final Table table) {
        String message;

        if (!table.startEvent()) {
            return NONE_MESSAGE + "\n";
        }
        message = makeDiscountMessage("크리스마스 디데이 할인", table.getChristmasDayDiscount());
        message += makeDiscountMessage("평일 할인", table.getWeekdayDiscount());
        message += makeDiscountMessage("주말 할인", table.getWeekendDiscount());
        message += makeDiscountMessage("특별 할인", table.getSpecialDiscount());
        if (!Objects.equals(table.getGiftMenu(), Benefit.NONE)) {
            message += makeDiscountMessage("증정 이벤트", table.getGiftBenefit());
        }
        return message;
    }

    private static String makeDiscountMessage(final String discountType, final int discountPrice) {
        if (discountPrice == 0) {
            return "";
        }
        return discountType + ": " + makePriceMessage(discountPrice * -1);
    }

    private static String makePriceMessage(final int price) {
        return convertFormat(price) + WON + "\n";
    }

    private static String convertFormat(final int message) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(message);
    }
}
