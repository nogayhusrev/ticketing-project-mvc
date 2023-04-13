package com.nogayhusrev.controller;

import com.nogayhusrev.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());

//        model.addAttribute("roles",find all roles from db);

        return "/user/create";
    }
}