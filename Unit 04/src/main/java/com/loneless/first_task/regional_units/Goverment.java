package com.loneless.first_task.regional_units;

import com.loneless.first_task.Administrative;

import java.util.ArrayList;

public class Goverment implements Administrative {
    private ArrayList<Region> regions=new ArrayList<>();
    private City capital;

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
}
