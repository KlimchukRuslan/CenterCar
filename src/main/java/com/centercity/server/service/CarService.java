package com.centercity.server.service;

import com.centercity.server.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Car getByID(long id);
    Car save(Car car);
    void remove(long id);
    int validForm(Car carForm);
    boolean updateCar(Car car, Long userId);
    void updateDriverCar(String driver, Long userId, String probeg);
    void updateDriverCarforManual(String driver, Long userId, String probeg, String time);
}
