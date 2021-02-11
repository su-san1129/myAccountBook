package jp.co.demo.myAccountBook.form;

import lombok.Data;

@Data
public class FoodExpenseForm {
    private Integer value;
    private Integer mealTimes;
    private String comment;
}
