package cuc.waimai.Dao;

import java.util.Date;

public class Horseman {
    private Integer horsemanId;

    private String horsemanName;

    private String horsemanPsd;

    private Integer horsemanTel;

    private Byte horsemanStatus;

    private String horesemanAdd;

    private Byte takeoutNum;

    private Date accomplishTime;

    private Double horsemanLon;

    private Double horsemanLat;

    private Date horsemanCreatetime;

    public Integer getHorsemanId() {
        return horsemanId;
    }

    public void setHorsemanId(Integer horsemanId) {
        this.horsemanId = horsemanId;
    }

    public String getHorsemanName() {
        return horsemanName;
    }

    public void setHorsemanName(String horsemanName) {
        this.horsemanName = horsemanName == null ? null : horsemanName.trim();
    }

    public String getHorsemanPsd() {
        return horsemanPsd;
    }

    public void setHorsemanPsd(String horsemanPsd) {
        this.horsemanPsd = horsemanPsd == null ? null : horsemanPsd.trim();
    }

    public Integer getHorsemanTel() {
        return horsemanTel;
    }

    public void setHorsemanTel(Integer horsemanTel) {
        this.horsemanTel = horsemanTel;
    }

    public Byte getHorsemanStatus() {
        return horsemanStatus;
    }

    public void setHorsemanStatus(Byte horsemanStatus) {
        this.horsemanStatus = horsemanStatus;
    }

    public String getHoresemanAdd() {
        return horesemanAdd;
    }

    public void setHoresemanAdd(String horesemanAdd) {
        this.horesemanAdd = horesemanAdd == null ? null : horesemanAdd.trim();
    }

    public Byte getTakeoutNum() {
        return takeoutNum;
    }

    public void setTakeoutNum(Byte takeoutNum) {
        this.takeoutNum = takeoutNum;
    }

    public Date getAccomplishTime() {
        return accomplishTime;
    }

    public void setAccomplishTime(Date accomplishTime) {
        this.accomplishTime = accomplishTime;
    }

    public Double getHorsemanLon() {
        return horsemanLon;
    }

    public void setHorsemanLon(Double horsemanLon) {
        this.horsemanLon = horsemanLon;
    }

    public Double getHorsemanLat() {
        return horsemanLat;
    }

    public void setHorsemanLat(Double horsemanLat) {
        this.horsemanLat = horsemanLat;
    }

    public Date getHorsemanCreatetime() {
        return horsemanCreatetime;
    }

    public void setHorsemanCreatetime(Date horsemanCreatetime) {
        this.horsemanCreatetime = horsemanCreatetime;
    }
}