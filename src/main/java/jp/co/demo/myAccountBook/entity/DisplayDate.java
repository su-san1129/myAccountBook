package jp.co.demo.myAccountBook.entity;

import jp.co.demo.myAccountBook.common.DayOfWeek;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class DisplayDate {

    private LocalDate localDate;

    private DisplayDate(final LocalDate localDate) {
        this.localDate = localDate;
    }

    public static DisplayDate of(final LocalDate localDate) {
        return new DisplayDate(localDate);
    }

    public String getFormatDate() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M月dd日");
        final String parsed = this.localDate.format(formatter);
        return String.format("%s(%s)", parsed, DayOfWeek.dayOfWeekEnumOf(this.localDate.getDayOfWeek()));
    }
}
