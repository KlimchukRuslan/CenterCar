package com.centercity.server.controller;

import com.centercity.server.entity.Car;
import com.centercity.server.service.CarService;
import com.centercity.server.tracker.GpsTrackerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class ProbegCarController {
    @Autowired
    private CarService carService;

    @GetMapping("/probeg_car")
    public String registration(Model model) {
        List<Car> list_car = carService.getAll();
        Collections.sort(list_car, Car::compareTo);
        model.addAttribute("allCar", list_car);

        return "car/data_all_cars";
    }

    @PostMapping("/data_car")
    public String dataCar (@RequestParam(required = true, defaultValue = "" ) Long carId,
                           @RequestParam(required = true, defaultValue = "" ) String  all,
                           @RequestParam(required = true, defaultValue = "" ) String date_first,
                           @RequestParam(required = true, defaultValue = "" ) String date_second,
                           Model model) {

        System.out.println("first = " + date_first);
        System.out.println("second = " + date_second);

        Date date_start = new Date();
        Date date_end = new Date();
        if (!date_first.equals("") && !date_second.equals("")){
            try {
                date_start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date_first);
                date_end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date_second);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Ошибка");
        }

        System.out.println(date_start);
        System.out.println(date_end);

        if (all.equals("All")){
            List<Car> list_car = carService.getAll();
            Collections.sort(list_car, Car::compareTo);
            System.out.println(list_car.size());
            List<Car> carList = new ArrayList<>();

            for (Car car: list_car) {
                try {
                    car.setProbeg(new GpsTrackerApi().getProbegCar(car.getTracker(),  String.valueOf(date_start.getTime()),  String.valueOf(date_end.getTime())));
                } catch (IOException e) {
                    System.out.println("Ошибка запроса данных с МегаGPS" + e);
                }
                carList.add(car);
            }

            model.addAttribute("allCar", carList);

            return "car/get_all_data_cars";
        }

        if (carId!=null) {
            List<Car> list_car = carService.getAll();
            Collections.sort(list_car, Car::compareTo);
            System.out.println(list_car.size());
            List<Car> carList = new ArrayList<>();
            for (Car car : list_car) {
                if (car.getId()==carId){
                    try {
                        car.setProbeg(new GpsTrackerApi().getProbegCar(car.getTracker(), String.valueOf(date_start.getTime()), String.valueOf(date_end.getTime())));
                    } catch (IOException e) {
                        System.out.println("Ошибка запроса данных с МегаGPS" + e);
                    }
                    carList.add(car);
                }
            }
            model.addAttribute("allCar", carList);

            return "car/get_all_data_cars";
        }
        return "car/get_all_data_cars";
    }
}
