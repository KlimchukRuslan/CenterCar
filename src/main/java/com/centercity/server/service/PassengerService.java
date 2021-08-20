package com.centercity.server.service;

import com.centercity.server.entity.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> getAll();
    Passenger getByID(long id);
    Passenger save(Passenger passenger);
    void remove(long id);
    int validForm(Passenger carForm);
    boolean updateCar(Passenger passenger, Long userId);
    void updateDriverCar(String driver, Long userId, String probeg);

}
