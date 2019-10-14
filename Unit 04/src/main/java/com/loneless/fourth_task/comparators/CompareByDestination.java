package com.loneless.fourth_task.comparators;

import com.loneless.fourth_task.travel_vouchers.TravelVoucher;

import java.util.Comparator;

public class CompareByDestination implements Comparator<TravelVoucher> {

        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            if(o1.getDestination().compareTo(o2.getDestination())==0)
                return 0;
            else if(o1.getDestination().compareTo(o2.getDestination())>0)
                return 1;
            else return -1;
        }
}
