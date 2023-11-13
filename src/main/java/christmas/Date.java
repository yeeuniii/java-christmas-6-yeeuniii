package christmas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Date {
    public static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final int EVENT_START_DAY = 1;
    private static final int EVENT_END_DAY = 31;
    private static final int CHRISTMAS_EVENT_END_DAY = 25;
    private static final List<Integer> WEEKEND = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private static final List<Integer> STAR = Arrays.asList(3, 10, 17, 24, 25, 31);

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

    public boolean isEvent() {
        return day >= EVENT_START_DAY && day <= EVENT_END_DAY;
    }

    public boolean isChristmasEvent() {
        return day >= EVENT_START_DAY && day <= CHRISTMAS_EVENT_END_DAY;
    }

    public boolean isWeekend() {
        return WEEKEND.contains(day);
    }

    public boolean isStar() {
        return STAR.contains(day);
    }
}
