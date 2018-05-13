package cuc.waimai.entity;

public class FoodShop {
    private Integer foodShopId;

    private Integer foodId;

    private Integer shopId;

    private Integer foodNum;

    private Double foodPrice;

    private Integer foodSales;

    private String foodEv;

    private String foodPic;

    private String foodDes;

    public Integer getFoodShopId() {
        return foodShopId;
    }

    public void setFoodShopId(Integer foodShopId) {
        this.foodShopId = foodShopId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getFoodSales() {
        return foodSales;
    }

    public void setFoodSales(Integer foodSales) {
        this.foodSales = foodSales;
    }

    public String getFoodEv() {
        return foodEv;
    }

    public void setFoodEv(String foodEv) {
        this.foodEv = foodEv == null ? null : foodEv.trim();
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic == null ? null : foodPic.trim();
    }

    public String getFoodDes() {
        return foodDes;
    }

    public void setFoodDes(String foodDes) {
        this.foodDes = foodDes == null ? null : foodDes.trim();
    }
}