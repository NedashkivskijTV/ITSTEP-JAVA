package com.example.spring4.controller;

import com.example.spring4.entity.User;
import com.example.spring4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "regisnration";
        }

        if(userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Паролі не співпадають");
            return "regisnration";
        }

        if(!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Користувач з таким іменем вже існує");
            return "regisnration";
        }

        return "redirect:/";
    }
}
