package com.centercity.server.controller;

import com.centercity.server.entity.Car;
import com.centercity.server.entity.TransferCar;
import com.centercity.server.entity.User;
import com.centercity.server.gsheet.SheetsGoogle;
import com.centercity.server.service.CarService;
import com.centercity.server.service.TransferCarService;
import com.centercity.server.service.UserService;
import com.centercity.server.work.GpsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class TransferUserControler {

    @Autowired
    private TransferCarService transferCarService;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @GetMapping("/data_user")
    public String registration(Model model) {

        List<User> list = userService.allUsers();
        model.addAttribute("allDataUsers", list);

        return "user/data_all_users";
    }

    @PostMapping("/data_user")
    public String dataUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                           @RequestParam(required = true, defaultValue = "" ) String  all,
                           @RequestParam(required = true, defaultValue = "" ) String date_first,
                           @RequestParam(required = true, defaultValue = "" ) String date_second,
                           Model model) {

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

        if (all.equals("All")){
            List<User> list = userService.allUsers();
            List<TransferCar> all_transfer = new ArrayList<>();
            HashMap<String, String> user_data = new HashMap<String, String>();

            for (User us: list) {
                user_data.put(us.getDriver_code(), us.getUsername());
                TransferCar transferCar = new TransferCar();
                System.out.println(us.getId());
                //Загрузка данных с пересменнок
                List<TransferCar> parseData = getProbegOne(us.getId(), date_start, date_end);

                transferCar.setDriver_code(us.getDriver_code());
                //Вместо номера передается имя водителя
                transferCar.setCar_number(us.getUsername());
                transferCar.setTake_the_car(date_start);
                transferCar.setGive_the_car(date_end);
                transferCar.setProbeg(String.valueOf(sumProbeg(parseData)));
                all_transfer.add(transferCar);
                System.out.println(us.getUsername());
            }
            model.addAttribute("allData", all_transfer);
            try {
                new SheetsGoogle().saveProbegDrivers(all_transfer, user_data);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                System.out.println("Проблема при записи в google таблицу " + e);
            }
            model.addAttribute("sum_probeg", sumProbeg(all_transfer));
            return "user/get_all_data_user";
        }

        if (userId!=null){

            List<TransferCar> allData = transferCarService.findDataTransfer(userService.findUserById(userId).getDriver_code());
            List<TransferCar> parseData = new ArrayList<>();

            //проверяем есть ли пересменки у водителя | Если нет - проверяем на наличие автомобиля у него
            TransferCar tc = addTransfer(userId, date_start, date_end);

            if (tc!=null){
                allData.add(tc);
            }
//            Проверка на попадние пересменок в диапазон требуемых дат
            for (TransferCar pd: allData) {
                if (isOverlapping(date_start, date_end, pd.getTake_the_car(), pd.getGive_the_car())){
                    parseData.add(pd);
                }
            }

            if (parseData.size() == 0){
                model.addAttribute("allData", parseData);
                return "user/data_user";
            }else {
                getProbeg(parseData, date_start, date_end);
            }

            model.addAttribute("allData", parseData);
            model.addAttribute("sum_probeg", sumProbeg(parseData));
            return "user/data_user";
        }

        return "user/data_user";
    }


    public List<TransferCar> getProbegOne (Long userId, Date date_start, Date date_end) {

        List<TransferCar> allData = transferCarService.findDataTransfer(userService.findUserById(userId).getDriver_code());
        List<TransferCar> parseData = new ArrayList<>();

        TransferCar tc = addTransfer(userId, date_start, date_end);

        if (tc!=null){
            allData.add(tc);
        }

        for (TransferCar pd: allData) {
            if (isOverlapping(date_start, date_end, pd.getTake_the_car(), pd.getGive_the_car())){
                parseData.add(pd);
            }
        }

        if (parseData.size() == 0){
            return parseData;
        }else {
            getProbeg(parseData, date_start, date_end);
        }
        return parseData;
    }

    public TransferCar addTransfer(Long userId, Date date_start, Date date_end){
        List<Car> carList = carService.getAll();
        User user = userService.findUserById(userId);
        TransferCar tc = new TransferCar();
        for (Car car : carList) {
//                Проверяем есть ли водитель на машине из списка
            if (car.getCar_driver().equals(user.getUsername())){

                tc.setDriver_code(user.getDriver_code());
                tc.setTreker(car.getTracker());
                tc.setCar_number(car.getCar_number());

                Date date_take = new Date(Long.parseLong(car.getDate_last_transfer()));

                if (date_start.getTime() > date_take.getTime()){
                    tc.setTake_the_car(date_start);
                    tc.setGive_the_car(date_end);
                    return tc;
                }

                if (date_start.getTime() < date_take.getTime()){
                    tc.setTake_the_car(date_take);
                    tc.setGive_the_car(date_end);
                    return tc;
                }
            }
        }
        return null;
    }

    public int sumProbeg(List<TransferCar> parseData){
        int sum_probeg = 0;
        for (TransferCar pd: parseData) {
            if (pd.getProbeg()!=null){
                sum_probeg += Integer.parseInt(pd.getProbeg());
            }
        }
        return sum_probeg;
    }

    public void getProbeg(List<TransferCar> parseData, Date date_start, Date date_end) {

        for (TransferCar tc : parseData) {

//            _______1_____1'__________2'_____2_____ V1
            if (date_start.getTime() >= tc.getTake_the_car().getTime() &&
                    date_end.getTime() <= tc.getGive_the_car().getTime()){
                try {
                    tc.setProbeg(new GpsApi().getProbegCar(tc.getTreker(),
                            String.valueOf(date_start.getTime()),
                            String.valueOf(date_end.getTime())));
                } catch (IOException e) {
                    System.out.println("Проблема при считывании данных с трекера " + e);
                }

            }

//            __1'_____1_______________2'_____2_____ V2
            if (date_start.getTime() <= tc.getTake_the_car().getTime() &&
                    date_end.getTime() <= tc.getGive_the_car().getTime()) {
                try {
                    tc.setProbeg(new GpsApi().getProbegCar(tc.getTreker(),
                            String.valueOf(tc.getTake_the_car().getTime()),
                            String.valueOf(date_end.getTime())));
                } catch (IOException e) {
                    System.out.println("Проблема при считывании данных с трекера " + e);
                }

            }

//            _______1__________1'__________2___2'__ V3
            if (date_start.getTime() >= tc.getTake_the_car().getTime() &&
                    date_end.getTime() >= tc.getGive_the_car().getTime()) {
                try {
                    tc.setProbeg(new GpsApi().getProbegCar(tc.getTreker(),
                            String.valueOf(date_start.getTime()),
                            String.valueOf(tc.getGive_the_car().getTime())));
                } catch (IOException e) {
                    System.out.println("Проблема при считывании данных с трекера " + e);
                }

            }

//            ____1'___1__________2___2'__ V4
            if (date_start.getTime() <= tc.getTake_the_car().getTime() &&
                    date_end.getTime() >= tc.getGive_the_car().getTime()) {
                try {
                    tc.setProbeg(new GpsApi().getProbegCar(tc.getTreker(),
                            String.valueOf(tc.getTake_the_car().getTime()),
                            String.valueOf(tc.getGive_the_car().getTime())));
                } catch (IOException e) {
                    System.out.println("Проблема при считывании данных с трекера " + e);
                }
            }
        }
    }

    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return !start1.after(end2) && !start2.after(end1);
    }

}
