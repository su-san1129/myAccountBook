package jp.co.demo.myAccountBook.controller;

import jp.co.demo.myAccountBook.entity.LoginUser;
import jp.co.demo.myAccountBook.form.FoodExpenseForm;
import jp.co.demo.myAccountBook.service.FoodExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("food-expenses")
public class FoodExpenseController {

    private final FoodExpenseService foodExpenseService;

    @PostMapping("create")
    public String create(final FoodExpenseForm foodExpenseForm, @AuthenticationPrincipal LoginUser loginUser) {
        foodExpenseService.create(foodExpenseForm, loginUser.getUser());
        return "redirect:/";
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, final FoodExpenseForm foodExpenseForm, @AuthenticationPrincipal LoginUser loginUser) {
        foodExpenseService.edit(foodExpenseForm, loginUser.getUser());
        return "redirect:/";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, final FoodExpenseForm foodExpenseForm, @AuthenticationPrincipal LoginUser loginUser) {
        foodExpenseService.deleteById(id);
        return "redirect:/";
    }
}
