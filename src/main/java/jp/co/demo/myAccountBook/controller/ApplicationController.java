package jp.co.demo.myAccountBook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

    @GetMapping("login")
    public String index() {
        return "login";
    }
}
