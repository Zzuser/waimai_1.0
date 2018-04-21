package cuc.waimai.Dao;

import java.util.Date;

public class DailyBill {
    private Integer billId;

    private Integer shopId;

    private Integer orderNum;

    private String totalmoney;

    private Integer newCollectionNum;

    private Date billTime;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(String totalmoney) {
        this.totalmoney = totalmoney == null ? null : totalmoney.trim();
    }

    public Integer getNewCollectionNum() {
        return newCollectionNum;
    }

    public void setNewCollectionNum(Integer newCollectionNum) {
        this.newCollectionNum = newCollectionNum;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }
}