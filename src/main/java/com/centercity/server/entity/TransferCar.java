package com.centercity.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_transfer")
public class TransferCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String driver_code;
    private String car_number;
    private String treker;
    private Date take_the_car;
    private Date give_the_car;
    private String probeg;

    public TransferCar() {
    }

    public String getProbeg() {
        return probeg;
    }

    public void setProbeg(String probeg) {
        this.probeg = probeg;
    }

    public String getTreker() {
        return treker;
    }

    public void setTreker(String treker) {
        this.treker = treker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriver_code() {
        return driver_code;
    }

    public void setDriver_code(String driver_code) {
        this.driver_code = driver_code;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public Date getTake_the_car() {
        return take_the_car;
    }

    public void setTake_the_car(Date take_the_car) {
        this.take_the_car = take_the_car;
    }

    public Date getGive_the_car() {
        return give_the_car;
    }

    public void setGive_the_car(Date give_the_car) {
        this.give_the_car = give_the_car;
    }
}
