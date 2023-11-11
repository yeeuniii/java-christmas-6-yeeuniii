package christmas;

public class Application {
    public static void main(String[] args) {
        askVisitDate();
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
}
