package com.example.server.controller;

import com.example.server.entity.User;
import com.example.server.result.Result;
import com.example.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());

        User user = userService.get(username, requestUser.getPassword());
        if (user == null) {
            return new Result(400);
        }
        session.setAttribute("user", user);
        return new Result(200);
    }
}
