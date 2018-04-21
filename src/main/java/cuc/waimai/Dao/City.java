package cuc.waimai.Dao;

public class City {
    private Integer cityId;

    private String cityName;

    private Double cityLon;

    private Double cityLat;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Double getCityLon() {
        return cityLon;
    }

    public void setCityLon(Double cityLon) {
        this.cityLon = cityLon;
    }

    public Double getCityLat() {
        return cityLat;
    }

    public void setCityLat(Double cityLat) {
        this.cityLat = cityLat;
    }
}