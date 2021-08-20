package com.centercity.server.service;

import com.centercity.server.entity.TransferCar;

import java.util.List;

public interface TransferCarService  {
    List<TransferCar> getAll();
    TransferCar getByID(long id);
    TransferCar save(TransferCar transferCar);
    void remove(long id);
    List<TransferCar> findDataTransfer(String driver_code);
}

