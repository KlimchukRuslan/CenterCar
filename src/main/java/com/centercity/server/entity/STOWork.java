package com.centercity.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "table_car_work")
public class STOWork {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "car_number", nullable = false, length = 50)
    private String car_number;

    @Column(name = "probeg", nullable = false, length = 50)
    private int probeg;

    public int getProbeg() {
        return probeg;
    }

    public void setProbeg(int probeg) {
        this.probeg = probeg;
    }

    @Column(name = "worker", nullable = false, length = 50)
    private String worker;

    @Column(name = "works", nullable = false, length = 300)
    private String works;

    @Column(name = "work_date",nullable = false)
    private Date workDate;

    public STOWork() {
    }

    public long getId() {
        return id;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }
}
