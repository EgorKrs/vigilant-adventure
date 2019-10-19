package com.loneless.fourth_task.comparators;

import com.loneless.fourth_task.entity.TravelVoucher;

import java.util.Comparator;

    public class CompareByCost implements Comparator<TravelVoucher> {
        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            return Double.compare(o1.getCost(),o2.getCost());
        }
    }

