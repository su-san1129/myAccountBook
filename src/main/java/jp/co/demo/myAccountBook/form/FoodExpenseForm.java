package jp.co.demo.myAccountBook.form;

import lombok.Data;

import java.sql.Date;

@Data
public class FoodExpenseForm {
    private Integer value;
    private Integer mealTimes;
    private String comment;
    private Date registeredAt;
}
