package com.centercity.server.controller;

import com.centercity.server.entity.User;
import com.centercity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    Long id;

    @GetMapping("/update_user")
    public String update(Model model) {
        model.addAttribute("allEditUsers", userService.allUsers());
        return "update_user";
    }

    @PostMapping("/update_user")
    public String deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/update_user";
    }


    @PostMapping("/edit_user/id")
    public String setID(@RequestParam(required = true, defaultValue = "" ) Long userId) {

        id = userId;
            return "redirect:/edit_user";
    }

    @GetMapping("/edit_user")
    public String edit(Model model) {
        User user =  userService.usergtList(id);
        model.addAttribute("editForm", user);
        model.addAttribute("polzovatel", user.getUsername());
        return "edit_user";
    }

    @PostMapping("/edit_user")
    public String editUser(@ModelAttribute("editForm") @Valid User editForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "edit_user";
        }
        if (userService.updateUser(editForm, id)){
            return "redirect:/update_user";
        }else {
            System.out.println("Error update");
        }

        return "redirect:/update_user";
    }

    @PostMapping("/reset_pass/id")
    public String setPassID(@RequestParam(required = true, defaultValue = "" ) Long userId) {
        id = userId;
        return "redirect:/reset_pass";
    }

    @GetMapping("/reset_pass")
    public String editPass(Model model) {
        User user =  userService.usergtList(id);
        model.addAttribute("editForm", user);
        model.addAttribute("polzovatel", user.getUsername());
        return "user/reset_pass";
    }

    @PostMapping("/reset_pass")
    public String editPass(@ModelAttribute("editForm") @Valid User editForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/reset_pass";
        }
        if (!editForm.getPassword().equals(editForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "user/reset_pass";
        }
        if (userService.updatePass(editForm, id)){
            return "redirect:/update_user";
        }else {
            System.out.println("Error update");
        }

        return "redirect:/update_user";
    }
}
