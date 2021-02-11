package jp.co.demo.myAccountBook.controller;

import jp.co.demo.myAccountBook.entity.LoginUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("users")
public class UserController {

    @RequestMapping
    public String index(@AuthenticationPrincipal LoginUser loginUser) {
        return "user/index";
    }
}
