package cuc.waimai.Dao;

import java.util.Date;

public class DailyBill {
    private Integer billId;

    private Integer shopId;

    private Integer orderNum;

    private Double totalmoney;

    private Integer newCollectionNum;

    private Date billTime;

    private String shopStatus;

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

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
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

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus == null ? null : shopStatus.trim();
    }
}