package com.centercity.server.service;

import com.centercity.server.entity.STOWork;
import com.centercity.server.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository repository;

    public List<STOWork> getAll() {
        return repository.findAll();
    }

    public STOWork getByID(long id) {
        return repository.findById(id).get();
    }

    public STOWork save(STOWork stoWork) {
        return repository.saveAndFlush(stoWork);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }
}
