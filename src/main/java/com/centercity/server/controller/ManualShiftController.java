package com.centercity.server.controller;

import com.centercity.server.entity.Car;
import com.centercity.server.entity.TransferCar;
import com.centercity.server.entity.User;
import com.centercity.server.service.CarService;
import com.centercity.server.service.TransferCarService;
import com.centercity.server.service.UserService;
import com.centercity.server.tempobj.ShiftCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ManualShiftController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private TransferCarService transferCarService;


    @GetMapping("/add_transfer")
    public String registration(Model model) {
        model.addAttribute("carForm", new ShiftCar());

        List<String> carNumber = new ArrayList<String>();
        List<String> userNameOld = new ArrayList<String>();

        for (int i = 0; i<carService.getAll().size(); i++){
            carNumber.add(carService.getAll().get(i).getCar_number());
        }

        for (int i = 0; i<userService.allUsers().size(); i++){
            userNameOld.add(userService.allUsers().get(i).getUsername());
        }

        model.addAttribute("carNumber", carNumber);
        model.addAttribute("userName", userNameOld);

        return "transfer/addTransfer";
    }

    @PostMapping("/add_transfer")
    public String addTransfer(@ModelAttribute("carForm") @Valid ShiftCar carForm, BindingResult bindingResult, Model model) {

        Date date = new Date();

        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(carForm.getTime());
        } catch (ParseException e) {
            System.out.println("Проблемы при парсинге даты в контролере пересменки.... " + e);
        }

        System.out.println(date);
        System.out.println(carForm.getCar_number());
        System.out.println(carForm.getOld_driver());
        System.out.println(carForm.getNew_driver());

        List<Car> car = carService.getAll();
        List<User> user = userService.allUsers();
        TransferCar transferCar = new TransferCar();
        Long car_id;

        transferCar.setCar_number(carForm.getCar_number());

        for (int i = 0; i<car.size(); i++){
            if (car.get(i).getCar_number().equals(carForm.getCar_number())){
                transferCar.setTreker(car.get(i).getTracker());
                car_id = car.get(i).getId();

                if (carForm.getOld_driver().equals(car.get(i).getCar_driver())){
                    for (int k = 0; k<user.size(); k++){
                        if (user.get(k).getUsername().equals(carForm.getOld_driver()))
                            transferCar.setDriver_code(user.get(k).getDriver_code());
                    }
                }

                if (transferCar.getDriver_code()==null){
                    model.addAttribute("driverError", "Водители не совпадают...");
                    return "transfer/addTransfer";
                }

                transferCar.setTake_the_car(new Date(Long.parseLong(car.get(i).getDate_last_transfer())));
                try {
                    transferCar.setGive_the_car(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(carForm.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                transferCarService.save(transferCar);

                if (carForm.getProbeg()==null){
                    model.addAttribute("probegError", "Поле не может быть пустым...");
                    return "transfer/addTransfer";
                }
                try {
                    Date dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(carForm.getTime());
                    carService.updateDriverCarforManual(carForm.getNew_driver(), car_id, carForm.getProbeg(), String.valueOf(dt.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return "transfer/ok";
            }
        }
        return "transfer/error";
    }
}
