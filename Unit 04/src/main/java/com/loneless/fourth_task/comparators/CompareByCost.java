package com.loneless.fourth_task.comparators;

import com.loneless.fourth_task.travel_vouchers.TravelVoucher;

import java.util.Comparator;

    public class CompareByCost implements Comparator<TravelVoucher> {
        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            return Integer.compare(o1.getCost(),o2.getCost());
        }
    }

