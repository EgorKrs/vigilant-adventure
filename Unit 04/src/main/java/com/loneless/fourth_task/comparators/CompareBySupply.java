package com.loneless.fourth_task.comparators;

import com.loneless.fourth_task.entity.TravelVoucher;

import java.util.Comparator;

public class CompareBySupply implements Comparator<TravelVoucher> {

    @Override
    public int compare(TravelVoucher o1, TravelVoucher o2) {
        if(o1.getSupply().compareTo(o2.getSupply())==0)
            return 0;
        else if(o1.getSupply().compareTo(o2.getSupply())>0)
            return 1;
        else return -1;
    }
}
