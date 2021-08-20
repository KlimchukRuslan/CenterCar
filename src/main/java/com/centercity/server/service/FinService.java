package com.centercity.server.service;

import com.centercity.server.entity.FinDataUser;

import java.util.List;

public interface FinService {
    List<FinDataUser> getAll();
    FinDataUser getByID(long id);
    FinDataUser save(FinDataUser fin_data);
    void remove(long id);
    int validForm(FinDataUser finForm);
    boolean updateFin(FinDataUser fin_data);
    void updateDate(FinDataUser fu);
}
