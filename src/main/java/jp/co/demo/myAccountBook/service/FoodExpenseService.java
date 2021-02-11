package jp.co.demo.myAccountBook.service;

import jp.co.demo.myAccountBook.common.MealTime;
import jp.co.demo.myAccountBook.entity.FoodExpense;
import jp.co.demo.myAccountBook.entity.User;
import jp.co.demo.myAccountBook.form.FoodExpenseForm;
import jp.co.demo.myAccountBook.repository.FoodExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodExpenseService {

    private final FoodExpenseRepository foodExpenseRepository;

    public List<FoodExpense> getFoodExpensesByUserId(final Integer userId) {
        return foodExpenseRepository.findByUserId(userId);
    }

    public List<FoodExpense> getDayFoodExpensesByUserId(final Integer userId, final LocalDate date) {
        return foodExpenseRepository.findByUserId(userId).stream()
                .filter(foodExpense -> foodExpense.getCreatedAt().toLocalDateTime().getDayOfMonth() == date.getDayOfMonth())
                .collect(Collectors.toList());
    }

    public List<FoodExpense> getLunchFoodExpenses(final List<FoodExpense> foodExpenses) {
        return foodExpenses.stream()
                .filter(foodExpense -> foodExpense.getMealTimes().equals(MealTime.LUNCH.getType()))
                .collect(Collectors.toList());
    }

    public List<FoodExpense> getDinnerFoodExpenses(final List<FoodExpense> foodExpenses) {
        return foodExpenses .stream()
                .filter(foodExpense -> foodExpense.getMealTimes().equals(MealTime.DINNER.getType()))
                .collect(Collectors.toList());
    }

    public List<FoodExpense> getWeekFoodExpensesByUserId(final Integer userId, final LocalDate date) {
        return foodExpenseRepository.findByUserId(userId).stream()
                .filter(foodExpense -> {
                    final LocalDate localDate = foodExpense.getCreatedAt().toLocalDateTime().toLocalDate();
                    return localDate.isAfter(date.with(DayOfWeek.MONDAY).minusDays(1)) &&
                            localDate.isBefore(date.with(DayOfWeek.SUNDAY).plusDays(1));
                })
                .collect(Collectors.toList());
    }


    public void create(final FoodExpenseForm foodExpenseForm, final User user) {
        foodExpenseRepository.save(
                FoodExpense.builder()
                        .userId(user.getId())
                        .value(foodExpenseForm.getValue())
                        .mealTimes(foodExpenseForm.getMealTimes())
                        .comment(foodExpenseForm.getComment())
                        .createdAt(Timestamp.valueOf(LocalDateTime.now())).build()
        );
    }

    public void edit(final FoodExpenseForm foodExpenseForm, final User user) {
        foodExpenseRepository.save(
                FoodExpense.builder()
                        .userId(user.getId())
                        .value(foodExpenseForm.getValue())
                        .mealTimes(foodExpenseForm.getMealTimes())
                        .comment(foodExpenseForm.getComment())
                        .createdAt(Timestamp.valueOf(LocalDateTime.now())).build()
        );
    }

    public void deleteById(final Integer id) {
        foodExpenseRepository.deleteById(id);
    }
}
