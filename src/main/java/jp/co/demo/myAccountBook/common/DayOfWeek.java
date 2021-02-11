package jp.co.demo.myAccountBook.common;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DayOfWeek {

    MONDAY("月"),
    TUESDAY("火"),
    WEDNESDAY("水"),
    THURSDAY("木"),
    FRIDAY("金"),
    SATURDAY("土"),
    SUNDAY("日");

    private String value;

    DayOfWeek(String value) {
        this.value = value;
    }

    public static String dayOfWeekEnumOf(java.time.DayOfWeek dayOfWeek) {
        return Arrays.stream(DayOfWeek.values()).filter(d -> d.ordinal() + 1 == dayOfWeek.getValue())
                .findFirst()
                .orElseThrow()
                .getValue();
    }
}
