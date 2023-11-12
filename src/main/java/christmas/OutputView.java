package christmas;

public class OutputView {
    public static void displayEventPlanner(final Order order) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(order.getAllMenuList());
    }
}
