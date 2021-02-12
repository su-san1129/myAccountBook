package jp.co.demo.myAccountBook.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@Table("FOOD_EXPENSES")
public class FoodExpense {
    @Id
    private Integer id;
    private Integer userId;
    private Integer value;
    private String comment;
    private Integer mealTimes;
    private LocalDate registeredAt;
    private Timestamp createdAt;
}
