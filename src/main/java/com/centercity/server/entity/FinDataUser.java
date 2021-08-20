package com.centercity.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_fin")
public class FinDataUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String driver_code;
    private String val;
    private String dop_dohod;
    private String toplivo;
    private String sum_val_dop_d_top;
    private String pereplata_nal;
    private String bonus;
    private String sum_bonus;
    private String pred_week;
    private String pererashod;
    private String nedosdacha;
    private String moyka;
    private String date_avans;
    private String avans;
    private String data_vyplaty;
    private String vyplaty;
    private String drugoe;
    private String sum_drugoe;
    private String itogo;
    private String date;
    private String week;
    private String dates;

    @Column(columnDefinition = "boolean default false")
    private boolean show;

    public FinDataUser() {
    }

    public String getSum_val_dop_d_top() {
        return sum_val_dop_d_top;
    }

    public void setSum_val_dop_d_top(String sum_val_dop_d_top) {
        this.sum_val_dop_d_top = sum_val_dop_d_top;
    }

    public String getData_vyplaty() {
        return data_vyplaty;
    }

    public void setData_vyplaty(String data_vyplaty) {
        this.data_vyplaty = data_vyplaty;
    }

    public String getDate_avans() {
        return date_avans;
    }

    public void setDate_avans(String date_avans) {
        this.date_avans = date_avans;
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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDop_dohod() {
        return dop_dohod;
    }

    public void setDop_dohod(String dop_dohod) {
        this.dop_dohod = dop_dohod;
    }

    public String getToplivo() {
        return toplivo;
    }

    public void setToplivo(String toplivo) {
        this.toplivo = toplivo;
    }

    public String getPereplata_nal() {
        return pereplata_nal;
    }

    public void setPereplata_nal(String pereplata_nal) {
        this.pereplata_nal = pereplata_nal;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getSum_bonus() {
        return sum_bonus;
    }

    public void setSum_bonus(String sum_bonus) {
        this.sum_bonus = sum_bonus;
    }

    public String getPred_week() {
        return pred_week;
    }

    public void setPred_week(String pred_week) {
        this.pred_week = pred_week;
    }

    public String getPererashod() {
        return pererashod;
    }

    public void setPererashod(String pererashod) {
        this.pererashod = pererashod;
    }

    public String getNedosdacha() {
        return nedosdacha;
    }

    public void setNedosdacha(String nedosdacha) {
        this.nedosdacha = nedosdacha;
    }

    public String getMoyka() {
        return moyka;
    }

    public void setMoyka(String moyka) {
        this.moyka = moyka;
    }

    public String getAvans() {
        return avans;
    }

    public void setAvans(String avans) {
        this.avans = avans;
    }

    public String getVyplaty() {
        return vyplaty;
    }

    public void setVyplaty(String vyplaty) {
        this.vyplaty = vyplaty;
    }

    public String getDrugoe() {
        return drugoe;
    }

    public void setDrugoe(String drugoe) {
        this.drugoe = drugoe;
    }

    public String getSum_drugoe() {
        return sum_drugoe;
    }

    public void setSum_drugoe(String sum_drugoe) {
        this.sum_drugoe = sum_drugoe;
    }

    public String getItogo() {
        return itogo;
    }

    public void setItogo(String itogo) {
        this.itogo = itogo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
