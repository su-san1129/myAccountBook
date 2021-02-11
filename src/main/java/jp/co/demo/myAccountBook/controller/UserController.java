package jp.co.demo.myAccountBook.controller;

import jp.co.demo.myAccountBook.common.CommonUtils;
import jp.co.demo.myAccountBook.entity.FoodExpense;
import jp.co.demo.myAccountBook.entity.LoginUser;
import jp.co.demo.myAccountBook.service.FoodExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final FoodExpenseService foodExpenseService;

    @RequestMapping
    public String index(@AuthenticationPrincipal LoginUser loginUser, Model model) {
        final List<FoodExpense> foodExpenses = foodExpenseService.getDayFoodExpensesByUserId(loginUser.getUser().getId(), LocalDate.now());

        final List<FoodExpense> foodExpensesOfLunch = foodExpenseService.getLunchFoodExpenses(foodExpenses);
        final int totalLunchValue = foodExpensesOfLunch.stream().mapToInt(FoodExpense::getValue).sum();
        final List<FoodExpense> foodExpensesOfDinner = foodExpenseService.getDinnerFoodExpenses(foodExpenses);
        final int totalDinnerValue = foodExpensesOfDinner.stream().mapToInt(FoodExpense::getValue).sum();

        model.addAttribute("today", CommonUtils.formatDate());
        model.addAttribute("foodExpensesOfLunch", foodExpensesOfLunch);
        model.addAttribute("totalLunchValue", totalLunchValue);
        model.addAttribute("foodExpensesOfDinner", foodExpensesOfDinner);
        model.addAttribute("totalDinnerValue", totalDinnerValue);

        return "user/index";
    }
}
