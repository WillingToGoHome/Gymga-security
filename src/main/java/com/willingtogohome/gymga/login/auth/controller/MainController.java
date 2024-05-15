package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.auth.model.service.AuthService;
import com.willingtogohome.gymga.login.common.UserRole;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.willingtogohome.gymga.login.common.UserRole.ADMIN;

@Controller
public class MainController {


    @GetMapping(value = "/login")
    public void login(){}

    @GetMapping(value = "/login/auth/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");

        return mv;
    }

    @GetMapping(value = "/main")
    public String main(){
        return "main";
    }

}
