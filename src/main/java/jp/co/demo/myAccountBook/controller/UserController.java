package jp.co.demo.myAccountBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("users")
public class UserController {

    @RequestMapping
    public String index() {
        return "user/index";
    }
}
