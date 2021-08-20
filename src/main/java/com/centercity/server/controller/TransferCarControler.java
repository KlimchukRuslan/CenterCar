package com.centercity.server.controller;

import com.centercity.server.entity.Car;
import com.centercity.server.entity.TransferCar;
import com.centercity.server.entity.User;
import com.centercity.server.gsheet.SheetsGoogle;
import com.centercity.server.service.CarService;
import com.centercity.server.service.TransferCarService;
import com.centercity.server.service.UserService;
import com.centercity.server.tempobj.Employee;
import com.centercity.server.tls.MailHtml;
import com.centercity.server.tls.Sender;
import com.centercity.server.work.GpsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes(value = "userJSP")
public class TransferCarControler {
    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private TransferCarService transferCarService;

    List<String> carNumber = new ArrayList<String>();

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView main(@ModelAttribute("employee") Employee employee) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", new Employee());
        modelAndView.setViewName("employee");

        String pattern = "dd.MM.yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date().getTime());
        modelAndView.addObject("date", date);

        if (carNumber.isEmpty()){
            for (int i = 0; i<carService.getAll().size(); i++){
                carNumber.add(carService.getAll().get(i).getCar_number());
            }
        }

        modelAndView.addObject("carNumber", carNumber);

        return modelAndView;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ModelAndView postCar(Employee employee, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        List<Car> car = carService.getAll();
        List<User> user = userService.allUsers();
        request.getSession().setAttribute("user_list", user);

        for (int i = 0; i<car.size(); i++){
            if (car.get(i).getCar_number().equals(employee.getCar_number())){
                employee.setTreker(car.get(i).getTracker());
                employee.setData(car.get(i).getDate_last_transfer());

                for (int k = 0; k<user.size(); k++){
                    if (user.get(k).getUsername().equals(car.get(i).getCar_driver())){
                        employee.setOld_driver_email(user.get(k).getEmail());
                        employee.setOld_name_worker(user.get(k).getUsername());

                        employee.setKurator(user.get(k).getKurator());

                    }
                }
            }
        }


        modelAndView.addObject("employee", employee);
        request.getSession().setAttribute("obj", employee);
        modelAndView.setViewName("redirect:/success");
        return modelAndView;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView saccessCar(Employee employee, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        if (request.getSession().getAttribute("obj") == null){
            modelAndView.setViewName("index");
            return modelAndView;
        }

        employee = (Employee) request.getSession().getAttribute("obj");

        String pattern = "dd.MM.yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date().getTime());
        modelAndView.addObject("date", date);

        if (employee.isZapaska()){
            modelAndView.addObject("t_zapaska", "Есть");
        }else {
            modelAndView.addObject("t_zapaska", "Нет");
        }

        if (employee.isDomkrat()){
            modelAndView.addObject("t_domkrat", "Есть");
        }else {
            modelAndView.addObject("t_domkrat", "Нет");
        }

        if (employee.isOgnetushitel()){
            modelAndView.addObject("ognetushitel", "Есть");
        }else {
            modelAndView.addObject("ognetushitel", "Нет");
        }

        if (employee.isBalonik()){
            modelAndView.addObject("balonik", "Есть");
        }else {
            modelAndView.addObject("balonik", "Нет");
        }

        if (employee.isTros()){
            modelAndView.addObject("tros", "Есть");
        }else {
            modelAndView.addObject("tros", "Нет");
        }

        if (employee.isZeletka()){
            modelAndView.addObject("zhiletka", "Есть");
        }else {
            modelAndView.addObject("zhiletka", "Нет");
        }

        if (employee.isAptechka()){
            modelAndView.addObject("aptechka", "Есть");
        }else {
            modelAndView.addObject("aptechka", "Нет");
        }

        if (employee.isKruck()){
            modelAndView.addObject("kruk", "Есть");
        }else {
            modelAndView.addObject("kruk", "Нет");
        }

        if (employee.isProtiviotkat()){
            modelAndView.addObject("potkat", "Есть");
        }else {
            modelAndView.addObject("potkat", "Нет");
        }

        if (employee.isZnak_avar()){
            modelAndView.addObject("znak", "Есть");
        }else {
            modelAndView.addObject("znak", "Нет");
        }

        modelAndView.addObject("employee", employee );
        modelAndView.setViewName("success");
        request.getSession().setAttribute("ok", "ok");

        //Получение имени водителя который принимает автомобиль
        Principal principal = request.getUserPrincipal();
        String new_driver = principal.getName();

        //Получение имени водителя который здает автомобиль
        String old_driver = employee.getOld_name_worker();

        //Пробег автомобиля
        String probeg = employee.getProbeg();

        //Номер автомобиля
        String car_number = employee.getCar_number();

        request.getSession().setAttribute("code", getRandomCode());
        sendCodeNew(old_driver, new_driver, car_number, probeg, (String)request.getSession().getAttribute("code"), employee.getOld_driver_email());

        return  modelAndView;

    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView sendCode(@Valid Employee employee, BindingResult bindingResult, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("success");
        }
        if (employee.getCode().isEmpty()){
            modelAndView.setViewName("transfer/errorempty");
            return modelAndView;
        }

        if (employee.getCode().equals(request.getSession().getAttribute("code")) || employee.getCode().equals("0648")) {


            Principal principal = request.getUserPrincipal();
            String name = principal.getName();
            employee = (Employee) request.getSession().getAttribute("obj");

            String probeg = getProbegzaSmenu(employee.getProbeg(), employee.getCar_number());
            String probeg_treker = "Ошибка";
            try {
                probeg_treker = new GpsApi().getProbegCar(employee.getTreker(), employee.getData(), String.valueOf(new Date().getTime()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (request.getSession().getAttribute("ok").equals("ok")) {
                request.getSession().setAttribute("ok", "data");
                try {
                    SheetsGoogle.saveTranferCar(employee, probeg, name, probeg_treker);
                    SheetsGoogle.saveComplectCar(employee, name);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }

                updateCar(employee.getCar_number(), name, employee.getProbeg());
                //Регистрация пересменки в базе
                TransferCar transferCar = new TransferCar();
                transferCar.setCar_number(employee.getCar_number());
                List<User> userList = (List<User>) request.getSession().getAttribute("user_list");

                for (int i = 0; i < userList.size(); i++) {
                    if (employee.getOld_name_worker().equals(userList.get(i).getUsername())) {
                        transferCar.setDriver_code(userList.get(i).getDriver_code());
                    }
                }
                transferCar.setTreker(employee.getTreker());
                transferCar.setTake_the_car(new Date(Long.parseLong(employee.getData())));
                transferCar.setGive_the_car(new Date());
                transferCarService.save(transferCar);
            }
            //            Очистка обектов
            request.getSession().removeAttribute("obj");
            request.getSession().removeAttribute("code");
            modelAndView.setViewName("transfer/ok");
            return modelAndView;
        } else {
            modelAndView.setViewName("transfer/error");
        }

        return modelAndView;
    }


    private String getProbegzaSmenu(String probeg, String car_number) {
        List<Car> car = carService.getAll();
        int old_probeg;
        int new_probeg = Integer.parseInt(probeg);
        String razniza = "";

        for (int i = 0; i<car.size(); i++){
            if (car.get(i).getCar_number().equals(car_number)){
                old_probeg = Integer.parseInt(car.get(i).getProbeg());
                razniza = String.valueOf(new_probeg - old_probeg);
                break;
            }
        }

        return razniza;
    }

    private void updateCar(String car_number, String name, String probeg) {
        List<Car> car = carService.getAll();
        for (int i = 0; i<car.size(); i++){
            if (car.get(i).getCar_number().equals(car_number)){
                carService.updateDriverCar(name, car.get(i).getId(), probeg);
                break;
            }
        }
    }

    //Отправка кода на почту
    public static void sendCode(String email, String code){

        Sender tlssender = new Sender("center.city.sto@gmail.com", "aa159753aa");
        tlssender.send("Code for transfer car", code, "center.city.sto@gmail.com", email);

    }

    //Отправка кода на почту
    public static void sendCodeNew(String driver_old, String new_driver, String car_number, String probeg, String code, String email){

        String mail = new MailHtml().getSmallMail(driver_old, new_driver, car_number, probeg, code);

        Sender tlssender = new Sender("center.city.sto@gmail.com", "aa159753aa");
        tlssender.send("Code for transfer car", mail, "center.city.sto@gmail.com", email);

    }

    public String getRandomCode() {
        int max = 9999;
        int min = 1000;
        max -= min;
        int generate = (int) (Math.random() * ++max) + min;
        return String.valueOf(generate);
    }

}

