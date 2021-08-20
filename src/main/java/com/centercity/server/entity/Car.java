package com.centercity.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_car")
public class Car implements Comparable<Car>{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "car_number", nullable = false, length = 50)
    private String car_number;

    @Column(name = "car_status", nullable = false, length = 50)
    private String car_status;

    @Column(name = "car_driver", nullable = false, length = 50)
    private String car_driver;

    @Column(name = "tracker", nullable = false, length = 50)
    private String tracker;

    private String car_kurator;
    @Size(min=2, message = "Не меньше 5 знаков")


    @Column(name = "probeg", nullable = false, length = 50)
    private String probeg;

    private String date_last_transfer;
    @Size(min=2, message = "Не меньше 5 знаков")

    public Car() {
    }

    @Override
    public int compareTo(Car emp) {
        return (int) (this.id - emp.id);
    }


    public String getDate_last_transfer() {
        return date_last_transfer;
    }

    public void setDate_last_transfer(String date_last_transfer) {
        this.date_last_transfer = date_last_transfer;
    }

    public String getCar_kurator() {
        return car_kurator;
    }

    public void setCar_kurator(String car_kurator) {
        this.car_kurator = car_kurator;
    }

    public String getCar_driver() {
        return car_driver;
    }

    public void setCar_driver(String car_driver) {
        this.car_driver = car_driver;
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status;
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getProbeg() {
        return probeg;
    }

    public void setProbeg(String probeg) {
        this.probeg = probeg;
    }
}