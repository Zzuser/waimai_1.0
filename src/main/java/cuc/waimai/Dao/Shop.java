package cuc.waimai.Dao;

public class Shop {
    private Integer shopId;

    private String shopName;

    private String shopPsw;

    private Integer shopTel;

    private String shopAdd;

    private String deliveryFee;

    private String shopProclamation;

    private Integer monthSales;

    private String orderNum;

    private Integer collectionNum;

    private Integer cityId;

    private Integer provinceId;

    private Double shopLat;

    private Double shopLon;

    private Integer shopCreatetime;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopPsw() {
        return shopPsw;
    }

    public void setShopPsw(String shopPsw) {
        this.shopPsw = shopPsw == null ? null : shopPsw.trim();
    }

    public Integer getShopTel() {
        return shopTel;
    }

    public void setShopTel(Integer shopTel) {
        this.shopTel = shopTel;
    }

    public String getShopAdd() {
        return shopAdd;
    }

    public void setShopAdd(String shopAdd) {
        this.shopAdd = shopAdd == null ? null : shopAdd.trim();
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee == null ? null : deliveryFee.trim();
    }

    public String getShopProclamation() {
        return shopProclamation;
    }

    public void setShopProclamation(String shopProclamation) {
        this.shopProclamation = shopProclamation == null ? null : shopProclamation.trim();
    }

    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Double getShopLat() {
        return shopLat;
    }

    public void setShopLat(Double shopLat) {
        this.shopLat = shopLat;
    }

    public Double getShopLon() {
        return shopLon;
    }

    public void setShopLon(Double shopLon) {
        this.shopLon = shopLon;
    }

    public Integer getShopCreatetime() {
        return shopCreatetime;
    }

    public void setShopCreatetime(Integer shopCreatetime) {
        this.shopCreatetime = shopCreatetime;
    }
}