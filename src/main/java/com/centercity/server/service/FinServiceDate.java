package com.centercity.server.service;

import com.centercity.server.entity.FinDateAndWeek;

import java.util.List;

public interface FinServiceDate {
    List<FinDateAndWeek> getAll();
    FinDateAndWeek getByID(long id);
    FinDateAndWeek save(FinDateAndWeek fin_data);
    void remove(long id);
    int validForm(FinDateAndWeek finForm);
    void updateDate(FinDateAndWeek fu);
}
