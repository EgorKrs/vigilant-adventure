package com.loneless.first_task.entity;

import com.loneless.first_task.Administrative;

import java.util.ArrayList;
import java.util.Objects;

public class District implements Administrative {
    private ArrayList<City> cities =new ArrayList<>();
    private City districtCenter;
    private String nameOfDistrict;
    public ArrayList<City> getCities() {
        return cities;
    }

    public District(ArrayList<City> cities, City districtCenter, String nameOfDistrict) {
        this.cities = cities;
        this.districtCenter = districtCenter;
        this.nameOfDistrict = nameOfDistrict;
    }

    public District() {
    }

    public District(City districtCenter, String nameOfDistrict) {
        this.districtCenter = districtCenter;
        this.nameOfDistrict = nameOfDistrict;
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

    public void addCity(City city){
        cities.add(city);
    }

    public City getCity(int index){
        return cities.get(index);
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

    @Override
    public StringBuilder receiveSmallerCenter() {
        StringBuilder smallerCenters=new StringBuilder();
        for (City city :
                cities) {
            smallerCenters.append(city.receiveHeadTerritory()).append(" ");
        }
        return smallerCenters;
    }

    @Override
    public String toString() {
        return "District{" +
                "cities=" + cities +
                ", districtCenter=" + districtCenter +
                ", nameOfDistrict='" + nameOfDistrict + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(cities, district.cities) &&
                Objects.equals(districtCenter, district.districtCenter) &&
                Objects.equals(nameOfDistrict, district.nameOfDistrict);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities, districtCenter, nameOfDistrict);
    }
}
