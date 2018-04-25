package cuc.waimai.po;

public class Message {
    private  String userId;
    private String shopId;
    private String foodId;
    private String foodNum;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(String foodNum) {
        this.foodNum = foodNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
