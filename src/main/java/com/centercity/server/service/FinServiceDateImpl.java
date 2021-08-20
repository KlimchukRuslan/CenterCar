package com.centercity.server.service;

import com.centercity.server.entity.FinDateAndWeek;
import com.centercity.server.repository.FinDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinServiceDateImpl implements FinServiceDate {

    @Autowired
    private FinDateRepository repository;

    public List<FinDateAndWeek> getAll() {
        return repository.findAll();
    }
    public FinDateAndWeek getByID(long id) {
        return repository.findById(id).get();
    }
    public FinDateAndWeek save(FinDateAndWeek fin_data) {
        return repository.saveAndFlush(fin_data);
    }
    public void remove(long id) {
        repository.deleteById(id);
    }
    public int validForm(FinDateAndWeek car){
        return 0;
    }

    public void updateDate(FinDateAndWeek finDataUser) {
        FinDateAndWeek fin_data = repository.findById(finDataUser.getId()).get();
        fin_data.setDate(finDataUser.getDate());
        fin_data.setWeek(finDataUser.getWeek());
        fin_data.setDates(finDataUser.getDates());
        fin_data.setShow(finDataUser.isShow());
        repository.save(fin_data);
    }
}
