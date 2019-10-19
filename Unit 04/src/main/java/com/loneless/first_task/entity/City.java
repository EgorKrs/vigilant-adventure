package com.loneless.first_task.entity;

import com.loneless.first_task.Administrative;

import java.util.Objects;

public class City implements Administrative {
    private double size;
    private String cityCenter;
    private String nameOfCity;

    public City(double size, String cityCenter, String nameOfCity) {
        this.size = size;
        this.cityCenter = cityCenter;
        this.nameOfCity = nameOfCity;
    }

    public City() {
    }

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

    @Override
    public StringBuilder receiveSmallerCenter() {
        return new StringBuilder();
    }

    @Override
    public String toString() {
        return "City{" +
                "size=" + size +
                ", cityCenter='" + cityCenter + '\'' +
                ", nameOfCity='" + nameOfCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.size, size) == 0 &&
                Objects.equals(cityCenter, city.cityCenter) &&
                Objects.equals(nameOfCity, city.nameOfCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, cityCenter, nameOfCity);
    }
}
