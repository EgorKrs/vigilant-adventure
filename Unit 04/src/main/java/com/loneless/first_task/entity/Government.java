package com.loneless.first_task.entity;

import com.loneless.first_task.Administrative;

import java.util.ArrayList;
import java.util.Objects;

public class Government implements Administrative {
    private ArrayList<Region> regions=new ArrayList<>();
    private String nameOfGovernment;
    private City capital;

    public Government() {
    }

    public Government(ArrayList<Region> regions, String name, City capital) {
        this.regions = regions;
        this.nameOfGovernment = name;
        this.capital = capital;
    }

    public String getNameOfGovernment() {
        return nameOfGovernment;
    }

    public void setNameOfGovernment(String nameOfGovernment) {
        this.nameOfGovernment = nameOfGovernment;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public void addRegion(Region region){
        regions.add(region);
    }

    public Region getRegion(int index){
        return regions.get(index);
    }

    @Override
    public double countSize() {
        int size=0;
        for (Region region :
                regions) {
            size += region.countSize();
        }
        return size;
    }

    @Override
    public String receiveHeadTerritory() {
        return capital.getNameOfCity();
    }

    @Override
    public int receiveQuantityOfIncomingTerritories() {
        return regions.size();
    }

    @Override
    public StringBuilder receiveSmallerCenter() {
        StringBuilder smallerCenters=new StringBuilder();
        for (Region region :
                regions) {
            smallerCenters.append(region.receiveHeadTerritory()).append(" ");
        }
        return smallerCenters;
    }

    @Override
    public String toString() {
        return "Government{" +
                "regions=" + regions +
                ", nameOfGovernment='" + nameOfGovernment + '\'' +
                ", capital=" + capital +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Government that = (Government) o;
        return Objects.equals(regions, that.regions) &&
                Objects.equals(nameOfGovernment, that.nameOfGovernment) &&
                Objects.equals(capital, that.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regions, nameOfGovernment, capital);
    }
}
