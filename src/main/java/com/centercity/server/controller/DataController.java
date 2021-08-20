package com.centercity.server.controller;

import com.centercity.server.entity.STOWork;
import com.centercity.server.gsheet.SheetsGoogle;
import com.centercity.server.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private WorkService service;

    @RequestMapping(value = "/works", method = RequestMethod.GET)
    @ResponseBody
    public List<STOWork> getAllWorks() {
        return service.getAll();
    }

    @RequestMapping(value = "/works/{id}", method = RequestMethod.GET)
    @ResponseBody
    public STOWork getOneWork(@PathVariable long id) {
        return service.getByID(id);
    }

    @RequestMapping(value = "/works", method = RequestMethod.POST)
    @ResponseBody
    public STOWork saveWork(@RequestBody STOWork remind) {
        try {
            SheetsGoogle.saveWork(remind);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return service.save(remind);
    }

    @RequestMapping(value = "/works/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public List<STOWork> getInfo() {
        return service.getAll();
    }

    @RequestMapping(value = "/set/{id}", method = RequestMethod.GET)
    @ResponseBody
    public STOWork setWork(@PathVariable long id) {
        try {
            SheetsGoogle.saveWork(service.getByID(id));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return service.getByID(id);
    }
}

