package com.centercity.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_passanger")
public class Passenger {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "count", nullable = false, length = 50)
    private String count;

    @Column(name = "car_number", nullable = false, length = 50)
    private String car_number;

    @Column(name = "date_passenger_boarding", nullable = false, length = 50)
    private String passenger_boarding;

    @Column(name = "date_passenger_disembarkation", nullable = false, length = 50)
    private String passenger_disembarkation;

    public Passenger() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getPassenger_boarding() {
        return passenger_boarding;
    }

    public void setPassenger_boarding(String passenger_boarding) {
        this.passenger_boarding = passenger_boarding;
    }

    public String getPassenger_disembarkation() {
        return passenger_disembarkation;
    }

    public void setPassenger_disembarkation(String passenger_disembarkation) {
        this.passenger_disembarkation = passenger_disembarkation;
    }
}