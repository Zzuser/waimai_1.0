package cuc.waimai.Dao;

public class ShopType {
    private Integer shoptypeId;

    private String typeName;

    public Integer getShoptypeId() {
        return shoptypeId;
    }

    public void setShoptypeId(Integer shoptypeId) {
        this.shoptypeId = shoptypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}