package jp.co.demo.myAccountBook.common;

import lombok.Getter;

@Getter
public enum MealTime {
    LUNCH(0),
    DINNER(1);

    private Integer type;

    MealTime(Integer type) {
        this.type = type;
    }
}
