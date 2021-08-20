package com.centercity.server.controller;

import com.centercity.server.entity.User;
import com.centercity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (userForm.getDriver_code().isEmpty()){
            model.addAttribute("driver_codeError", "Поле не может быть пустым");
            return "registration";
        }

        if (userForm.getKurator().isEmpty()){
            model.addAttribute("curatorError", "Поле не может быть пустым");
            return "registration";
        }

        if (userService.validForm(userForm)==1){
            model.addAttribute("emailError", "Пользователь с таким email уже существует");
            return "registration";
        }

        if (userService.validForm(userForm)==0){
            userService.saveUser(userForm);
        }

        return "redirect:/admin";
    }
}
