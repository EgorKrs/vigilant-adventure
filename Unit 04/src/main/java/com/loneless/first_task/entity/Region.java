package com.loneless.first_task.entity;

import com.loneless.first_task.Administrative;

import java.util.ArrayList;

public class Region implements Administrative {
    private ArrayList<District> districts=new ArrayList<>();
    private District centralDistrict;

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
    public String receiveHeadTerritory() {
        return centralDistrict.getNameOfDistrict();
    }
}
