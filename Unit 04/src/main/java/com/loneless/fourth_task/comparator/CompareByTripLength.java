package com.loneless.fourth_task.comparator;

import com.loneless.fourth_task.entity.TravelVoucher;

import java.util.Comparator;

public class CompareByTripLength implements Comparator<TravelVoucher> {
    @Override
    public int compare(TravelVoucher o1, TravelVoucher o2) {
        return Integer.compare(o1.getTripLength(),o2.getTripLength());
    }
}
