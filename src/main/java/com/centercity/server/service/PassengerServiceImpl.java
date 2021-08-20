package com.centercity.server.service;

import com.centercity.server.entity.Passenger;
import com.centercity.server.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository repository;

    public List<Passenger> getAll() {
        return repository.findAll();
    }

    public Passenger getByID(long id) {
        return repository.findById(id).get();
    }

    public Passenger save(Passenger passenger) {
        return repository.saveAndFlush(passenger);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public int validForm(Passenger passenger){
        return 0;
    }

    public boolean updateCar(Passenger passenger, Long passengerId) {

        Passenger old_passenger = repository.findById(passengerId).get();
        old_passenger.setCount(passenger.getCount());
        old_passenger.setPassenger_boarding(passenger.getPassenger_boarding());
        old_passenger.setPassenger_disembarkation(passenger.getPassenger_disembarkation());
        repository.save(old_passenger);
        return true;
    }

    public void updateDriverCar (String driver, Long userId, String probeg){
    }
}
