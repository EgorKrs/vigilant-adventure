package com.loneless.first_task.regional_units;

import com.loneless.first_task.Administrative;

import java.util.ArrayList;

public class District implements Administrative {
    private ArrayList<City> cities =new ArrayList<>();
    private City districtCenter;
    private String nameOfDistrict;
    public ArrayList<City> getCities() {
        return cities;
    }

    public String getNameOfDistrict() {
        return nameOfDistrict;
    }

    public void setNameOfDistrict(String nameOfDistrict) {
        this.nameOfDistrict = nameOfDistrict;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public City getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(City districtCenter) {
        this.districtCenter = districtCenter;
    }

    @Override
    public double countSize() {
        int size=0;
        for (City city :
                cities) {
            size+=city.getSize();
        }
        return size;
    }

    @Override
    public String receiveHeadTerritory() {
        return districtCenter.getNameOfCity();
    }

    @Override
    public int receiveQuantityOfIncomingTerritories() {
        return cities.size();
    }
}
