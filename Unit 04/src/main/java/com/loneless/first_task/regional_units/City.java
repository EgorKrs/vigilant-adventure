package com.loneless.first_task.regional_units;

import com.loneless.first_task.Administrative;

public class City implements Administrative {
    private double size;
    private String cityCenter;
    private String nameOfCity;
    public double getSize() {
        return size;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getCityCenter() {
        return cityCenter;
    }

    public void setCityCenter(String cityCenter) {
        this.cityCenter = cityCenter;
    }

    @Override
    public double countSize() {
        return size;
    }

    @Override
    public String receiveHeadTerritory() {
        return cityCenter;
    }

    @Override
    public int receiveQuantityOfIncomingTerritories() {
        return 0;
    }
}
