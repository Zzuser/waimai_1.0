package cuc.waimai.po;


import java.util.List;

public class OrderMessage {
    private  String userId;
    private String shopId;
    private List<FoodInOrder> foodInOrderList;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public List<FoodInOrder> getFoodInOrderList() {
        return foodInOrderList;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "userId='" + userId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", foodInOrderList=" + foodInOrderList +
                '}';
    }

    public void setFoodInOrderList(List<FoodInOrder> foodInOrderList) {
        this.foodInOrderList = foodInOrderList;
    }
}
