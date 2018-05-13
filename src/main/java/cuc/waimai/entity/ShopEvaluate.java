package cuc.waimai.entity;

public class ShopEvaluate {
    private Integer evId;

    private Integer shopId;

    private Integer userId;

    private Double evAll;

    private String evComment;

    private String evPic;

    public Integer getEvId() {
        return evId;
    }

    public void setEvId(Integer evId) {
        this.evId = evId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getEvAll() {
        return evAll;
    }

    public void setEvAll(Double evAll) {
        this.evAll = evAll;
    }

    public String getEvComment() {
        return evComment;
    }

    public void setEvComment(String evComment) {
        this.evComment = evComment == null ? null : evComment.trim();
    }

    public String getEvPic() {
        return evPic;
    }

    public void setEvPic(String evPic) {
        this.evPic = evPic == null ? null : evPic.trim();
    }
}