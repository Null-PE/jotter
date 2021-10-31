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

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());

        User user = userService.get(username, requestUser.getPassword());
        if (user == null) {
            return new Result(400);
        }
        return new Result(200);
    }
}
