package com.centercity.server.controller;

//Данный код работает только как API для контроллера ESP

import com.centercity.server.entity.Passenger;
import com.centercity.server.gsheet.SheetsGoogle;
import com.centercity.server.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @GetMapping("/passenger")
    public String getPassenger(Model model, @RequestParam String car_number,
                                            @RequestParam String pas1) {

        model.addAttribute("ps", pas1);
        Long id = getID(car_number);
        String count = passengerService.getByID(id).getCount();
        Long id_car = 1L;
        String pass = null;

        if (pas1.equals("1") && (count.equals("0"))){
            pass = "Посадка пассажира";
            Passenger passenger = new Passenger();
            passenger.setCount("1");
            passenger.setPassenger_boarding(parseDate(new Date()));
            passenger.setPassenger_disembarkation("null");
            passengerService.updateCar(passenger, id);

            try {
                new SheetsGoogle().addPassenger(car_number, pass, passenger.getPassenger_boarding());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }

        if (pas1.equals("0") && (count.equals("1"))){
            pass = "Высадка пассажира";
            Passenger passenger = new Passenger();
            passenger.setCount("0");
            passenger.setPassenger_boarding("null");
            passenger.setPassenger_disembarkation(parseDate(new Date()));
            passengerService.updateCar(passenger, id);

            try {
                new SheetsGoogle().addPassenger(car_number, pass, passenger.getPassenger_disembarkation());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
        return "car/passenger";
    }

    private Long getID(String car_number) {
        List<Passenger> list = passengerService.getAll();

        for (Passenger pas_list : list) {
            if (pas_list.getCar_number().equals(car_number)){
                return pas_list.getId();
            }
        }
        return null;
    }

    private String parseDate(Date date){
        String pattern = "dd.MM.yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
