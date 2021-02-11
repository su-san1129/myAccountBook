package jp.co.demo.myAccountBook.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

    public static String formatDate() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M月dd日");
        final LocalDate today = LocalDate.now();
        final String parsed = today.format(formatter);
        return String.format("%s(%s)", parsed, DayOfWeek.dayOfWeekEnumOf(today.getDayOfWeek()));
    }
}
