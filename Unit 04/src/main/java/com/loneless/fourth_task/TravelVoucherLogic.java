package com.loneless.fourth_task;


import com.loneless.fourth_task.comparators.*;
import com.loneless.fourth_task.entity.TravelVoucher;


import java.util.Comparator;
import java.util.List;

public class TravelVoucherLogic {

    private static final TravelVoucherLogic instance =new TravelVoucherLogic();

    private TravelVoucherLogic(){}

    public static TravelVoucherLogic getInstance() {
        return instance;
    }

    public void sort(String nameOfField, List<TravelVoucher> vouchers){
        Comparator<TravelVoucher> voucherComparator;
        switch (nameOfField) {
            case "destination":
                voucherComparator = new CompareByDestination();
                break;
            case "cost":
                voucherComparator = new CompareByCost();
                break;
            case "tripLength":
                voucherComparator = new CompareByTripLength();
                break;
            case "transport":
                voucherComparator = new CompareByTransport();
                break;
            case "supply":
                voucherComparator = new CompareBySupply();
                break;
            case "Id":
                voucherComparator=new CompareById();
                break;
                default:return;
        }
        vouchers.sort(voucherComparator);
    }
}
