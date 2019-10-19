package com.loneless.first_task.entity;

import com.loneless.first_task.Administrative;

import java.util.ArrayList;
import java.util.Objects;

public class Region implements Administrative {
    private ArrayList<District> districts=new ArrayList<>();

    private District centralDistrict;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    public District getCentralDistrict() {
        return centralDistrict;
    }

    public void setCentralDistrict(District centralDistrict) {
        this.centralDistrict = centralDistrict;
    }

    public void addDistrict(District district){
        districts.add(district);
    }

    public District getDistrict(int index){
        return districts.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(districts, region.districts) &&
                Objects.equals(centralDistrict, region.centralDistrict) &&
                Objects.equals(name, region.name);
    }

    @Override
    public double countSize() {
        int size=0;
        for (District district :
                districts) {
            size+=district.countSize();
        }
        return size;
    }

    @Override
    public int receiveQuantityOfIncomingTerritories() {
        return districts.size();
    }

    @Override
    public StringBuilder receiveSmallerCenter() {
        StringBuilder smallerCenters=new StringBuilder();
        for (District district :
                districts) {
            smallerCenters.append(district.receiveHeadTerritory()).append(" ");
        }
        return smallerCenters;
    }

    @Override
    public String receiveHeadTerritory() {
        return centralDistrict.getNameOfDistrict();
    }

    @Override
    public int hashCode() {
        return Objects.hash(districts, centralDistrict, name);
    }

    @Override
    public String toString() {
        return "Region{" +
                "districts=" + districts +
                ", centralDistrict=" + centralDistrict +
                ", name='" + name + '\'' +
                '}';
    }
}
