package christmas;

public class Date {
    private final int day;

    public Date(String day) {
        checkDayFormat(day);
        this.day = Integer.parseInt(day);
        checkRange();
    }

    private void checkDayFormat(String day) {
        if (isInvalidDay(day)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isInvalidDay(String day) {
        return !day.matches("\\d+");
    }

    private void checkRange() {
        if (isInvalidRange()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isInvalidRange() {
        return day < 1 || day > 31;
    }
}
