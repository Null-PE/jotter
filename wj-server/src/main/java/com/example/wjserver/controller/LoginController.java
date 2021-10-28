package com.example.wjserver.controller;

import com.example.wjserver.pojo.User;
import com.example.wjserver.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
    public static final String ADMIN = "admin";
    public static final String PS = "1234";

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());
        if (!ADMIN.equals(username) || !PS.equals(requestUser.getPassword())) {
            String message = "wrong password";
            return new Result(400);
        }
        System.out.println("[Admin] login...");
        return new Result(200);
    }
}
