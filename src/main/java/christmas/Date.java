package christmas;

public class Date {
    public static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final int day;

    public Date(String day) {
        checkDayFormat(day);
        this.day = Integer.parseInt(day);
        checkRange();
    }

    private void checkDayFormat(String day) {
        if (isInvalidDay(day)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private boolean isInvalidDay(String day) {
        return !day.matches("\\d+");
    }

    private void checkRange() {
        if (isInvalidRange()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private boolean isInvalidRange() {
        return day < 1 || day > 31;
    }
}
