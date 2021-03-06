package com.loneless.fourth_task.comparator;

import com.loneless.fourth_task.entity.TravelVoucher;

import java.util.Comparator;

public class CompareByTransport implements Comparator<TravelVoucher> {
        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            if(o1.getTransport().compareTo(o2.getTransport())==0)
                return 0;
            else if(o1.getTransport().compareTo(o2.getTransport())>0)
                return 1;
            else return -1;
        }
    }

