package cuc.waimai.Vo;

public class WorkbenchVO {
    private int pending_num;
    private int carrying_num;
    private int finish_num;
    private String shop_statue;
    private int new_collection;
    private int all_colledtion;


    public int getPending_num() {
        return pending_num;
    }

    public void setPending_num(int pending_num) {
        this.pending_num = pending_num;
    }

    public int getCarrying_num() {
        return carrying_num;
    }

    public void setCarrying_num(int carrying_num) {
        this.carrying_num = carrying_num;
    }

    public int getFinish_num() {
        return finish_num;
    }

    public void setFinish_num(int finish_num) {
        this.finish_num = finish_num;
    }

    public String getShop_statue() {
        return shop_statue;
    }

    public void setShop_statue(String shop_statue) {
        this.shop_statue = shop_statue;
    }

    public int getNew_collection() {
        return new_collection;
    }

    public void setNew_collection(int new_collection) {
        this.new_collection = new_collection;
    }

    public int getAll_colledtion() {
        return all_colledtion;
    }

    @Override
    public String toString() {
        return "WorkbenchVO{" +
                ", pending_num=" + pending_num +
                ", carrying_num=" + carrying_num +
                ", finish_num=" + finish_num +
                ", shop_statue='" + shop_statue + '\'' +
                ", new_collection=" + new_collection +
                ", all_colledtion=" + all_colledtion +
                '}';
    }

    public void setAll_colledtion(int all_colledtion) {
        this.all_colledtion = all_colledtion;
    }
}
