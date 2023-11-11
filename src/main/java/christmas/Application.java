package christmas;

public class Application {
    public static void main(String[] args) {
        askVisitDate();
        askMenuAndCount();
    }

    private static Date askVisitDate() {
        try {
            return new Date(InputView.inputVisitDate());
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return askVisitDate();
    }

    private static Order askMenuAndCount() {
        try {
            return new Order(InputView.inputMenuAndCount());
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return askMenuAndCount();
    }
}
