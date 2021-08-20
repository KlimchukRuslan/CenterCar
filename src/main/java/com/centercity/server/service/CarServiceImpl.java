package com.centercity.server.service;

import com.centercity.server.entity.Car;
import com.centercity.server.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> getAll() {
        return repository.findAll();
    }

    public Car getByID(long id) {
        return repository.findById(id).get();
    }

    public Car save(Car car) {
        return repository.saveAndFlush(car);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public int validForm(Car car){
        return 0;
    }

    public boolean updateCar(Car car, Long userId) {

        Car old_car = repository.findById(userId).get();
        old_car.setCar_number(car.getCar_number());
        old_car.setCar_kurator(car.getCar_kurator());
        old_car.setCar_status(car.getCar_status());
        old_car.setCar_driver(car.getCar_driver());
        old_car.setProbeg(car.getProbeg());
        old_car.setTracker(car.getTracker());

        repository.save(old_car);
        return true;
    }

    public void updateDriverCar (String driver, Long carId, String probeg){
        Car old_car = repository.findById(carId).get();
        old_car.setCar_driver(driver);
        old_car.setProbeg(probeg);
        old_car.setDate_last_transfer(String.valueOf(new Date().getTime()));
        repository.save(old_car);
    }

    public void updateDriverCarforManual (String driver, Long carId, String probeg, String time){
        Car old_car = repository.findById(carId).get();
        old_car.setCar_driver(driver);
        old_car.setProbeg(probeg);
        old_car.setDate_last_transfer(time);
        repository.save(old_car);
    }
}
