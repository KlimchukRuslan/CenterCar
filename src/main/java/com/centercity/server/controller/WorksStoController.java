package com.centercity.server.controller;

import com.centercity.server.entity.STOWork;
import com.centercity.server.gsheet.SheetsGoogle;
import com.centercity.server.service.CarService;
import com.centercity.server.service.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WorksStoController {
    @Autowired
    private WorkServiceImpl workService;

    @Autowired
    private CarService carService;
    List<String> carNumber = new ArrayList<String>();
    List<String> worker = new ArrayList<String>();


    @GetMapping("/reg_works")
    public String getSaveWork(Model model, STOWork stoWork) {
        model.addAttribute("STOWork", stoWork);
        if (carNumber.isEmpty()){
            for (int i = 0; i<carService.getAll().size(); i++){
                carNumber.add(carService.getAll().get(i).getCar_number());
            }
        }
        if (worker.isEmpty()){
            worker.add("*****");
            worker.add("*****");
            worker.add("*****");
            worker.add("*****");
        }

        model.addAttribute("carNumber", carNumber);
        model.addAttribute("worker", worker);

        return "sto/reg_works";
    }

    @PostMapping("/reg_works")
    public String postSaveWork(STOWork stoWork) {
        System.out.println(stoWork.getCar_number());
        System.out.println(stoWork.getWorker());
        System.out.println(stoWork.getProbeg());
        System.out.println(stoWork.getWorks());

        stoWork.setWorkDate(new Date());
        workService.save(stoWork);
        try {
            SheetsGoogle.saveWork(stoWork);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        carNumber = new ArrayList<String>();
        return "sto/ok";
    }

}
