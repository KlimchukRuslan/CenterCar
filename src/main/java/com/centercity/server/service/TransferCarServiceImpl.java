package com.centercity.server.service;

import com.centercity.server.entity.TransferCar;
import com.centercity.server.repository.TransferCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class TransferCarServiceImpl implements TransferCarService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TransferCarRepository repository;

    @Override
    public List<TransferCar> getAll() {
        return repository.findAll();
    }

    public TransferCar getByID(long id) {
        return repository.findById(id).get();
    }

    public TransferCar save(TransferCar transferCar) {
        return repository.saveAndFlush(transferCar);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public List<TransferCar> findDataTransfer(String driver_code) {

        Query query = em.createQuery("SELECT e FROM TransferCar e WHERE e.driver_code = :dv_code" );
        query.setParameter("dv_code", driver_code);
        List<TransferCar> resultList = query.getResultList();
        em.close();
        return resultList;
    }
}
