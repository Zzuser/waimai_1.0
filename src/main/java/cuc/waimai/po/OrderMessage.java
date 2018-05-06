package cuc.waimai.po;


import cuc.waimai.Vo.FoodVo;

import java.util.List;

public class OrderMessage {
    private String userId;
    private String shopId;
    private List<FoodVo> foodVoList;

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

    public List<FoodVo> getFoodVoList() {
        return foodVoList;
    }

    public void setFoodVoList(List<FoodVo> foodVoList) {
        this.foodVoList = foodVoList;
    }
}
