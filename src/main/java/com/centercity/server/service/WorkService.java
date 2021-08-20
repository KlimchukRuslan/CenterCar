package com.centercity.server.service;

import com.centercity.server.entity.STOWork;

import java.util.List;

public interface WorkService {
    List<STOWork> getAll();
    STOWork getByID(long id);
    STOWork save(STOWork stoWork);
    void remove(long id);
}
