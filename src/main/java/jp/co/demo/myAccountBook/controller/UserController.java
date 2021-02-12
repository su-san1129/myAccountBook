package jp.co.demo.myAccountBook.controller;

import jp.co.demo.myAccountBook.entity.DisplayDate;
import jp.co.demo.myAccountBook.entity.FoodExpense;
import jp.co.demo.myAccountBook.entity.LoginUser;
import jp.co.demo.myAccountBook.service.FoodExpenseService;
import jp.co.demo.myAccountBook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FoodExpenseService foodExpenseService;

    @RequestMapping
    public String index(@RequestParam(required = false) String date, @AuthenticationPrincipal LoginUser loginUser, Model model) {
        DisplayDate displayDate;

        if (date != null) {
            displayDate = DisplayDate.of(LocalDate.parse(date));
        } else {
            displayDate = DisplayDate.of(LocalDate.now());
        }

        final List<FoodExpense> foodExpenses = foodExpenseService.getDayFoodExpensesByUserId(loginUser.getUser().getId(), displayDate.getLocalDate());

        final List<FoodExpense> foodExpensesOfLunch = foodExpenseService.getLunchFoodExpenses(foodExpenses);
        final int totalLunchValue = foodExpensesOfLunch.stream().mapToInt(FoodExpense::getValue).sum();
        final List<FoodExpense> foodExpensesOfDinner = foodExpenseService.getDinnerFoodExpenses(foodExpenses);
        final int totalDinnerValue = foodExpensesOfDinner.stream().mapToInt(FoodExpense::getValue).sum();

        final List<FoodExpense> weekFoodExpenses = foodExpenseService.getWeekFoodExpensesByUserId(loginUser.getUser().getId(), displayDate.getLocalDate());
        final int totalWeekValue = foodExpenseService.getWeekFoodExpensesByUserId(loginUser.getUser().getId(), displayDate.getLocalDate()).stream().mapToInt(FoodExpense::getValue).sum();

        model.addAttribute("displayDate", displayDate);
        model.addAttribute("foodExpensesOfLunch", foodExpensesOfLunch);
        model.addAttribute("totalLunchValue", totalLunchValue);
        model.addAttribute("foodExpensesOfDinner", foodExpensesOfDinner);
        model.addAttribute("totalDinnerValue", totalDinnerValue);

        model.addAttribute("weekFoodExpenses", weekFoodExpenses);
        model.addAttribute("totalWeekValue", totalWeekValue);

        return "user/index";
    }

    @RequestMapping("/users/create")
    public String create(final String name, final String password, final String email) {
        userService.create(name, password, email);
        return "redirect:/";
    }
}
