package com.centercity.server.controller;

import com.centercity.server.entity.Car;
import com.centercity.server.service.CarService;
import com.centercity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CarController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    Long id;

    @GetMapping("/update_car")
    public String update(Model model) {
        model.addAttribute("allEditCars", carService.getAll());
        return "update_car";
    }

    @PostMapping("/update_car")
    public String deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model) {
        if (action.equals("delete")){
            carService.remove(userId);
        }
        return "redirect:/update_car";
    }

    @PostMapping("/edit_car/id")
    public String setID(@RequestParam(required = true, defaultValue = "" ) Long userId) {
        id = userId;
        return "redirect:/edit_car";
    }

    @GetMapping("/edit_car")
    public String edit(Model model) {
        Car car =  carService.getByID(id);
        model.addAttribute("carForm", car);
        model.addAttribute("car_number", car.getCar_number());
        return "edit_car";
    }

    @PostMapping("/edit_car")
    public String editUser(@ModelAttribute("carForm") @Valid Car carForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "edit_car";
        }

        if (carForm.getCar_number().isEmpty()){
            model.addAttribute("car_numberError", "Поле не может быть пустым");
            return "edit_car";
        }

        if (carService.validForm(carForm)==0){
            carService.updateCar(carForm, id);
        }

        return "redirect:/update_car";
    }

    @GetMapping("/add_car")
    public String addCar(Model model) {
        model.addAttribute("carForm", new Car());
        return "add_car";
    }

    @PostMapping("/add_car")
    public String saveCar(@ModelAttribute("carForm") @Valid Car carForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "add_car";
        }

        if (carForm.getCar_number().isEmpty()){
            model.addAttribute("car_numberError", "Поле не может быть пустым");
            return "add_car";
        }

        if (carService.validForm(carForm)==0){
            carService.save(carForm);
        }

        return "redirect:/update_car";
    }

}
