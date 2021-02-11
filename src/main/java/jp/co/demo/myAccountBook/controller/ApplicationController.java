package jp.co.demo.myAccountBook.controller;

import jp.co.demo.myAccountBook.common.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

    @GetMapping("login")
    public String index(@RequestParam(required = false) Optional<String> error, Model model) {
        error.ifPresent(
                s -> model.addAttribute(Message.LOGIN_ERROR.getKey(), Message.LOGIN_ERROR.getMsg())
        );
        return "login";
    }

    @RequestMapping("success")
    public String success() {
        return "redirect:/";
    }
}
