package com.loneless.fourth_task;


import com.loneless.fourth_task.comparator.*;
import com.loneless.fourth_task.entity.TravelVoucher;


import java.util.Comparator;
import java.util.LinkedList;
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

    public List<TravelVoucher> findNotes(String note, List<TravelVoucher> vouchers) {
        List<TravelVoucher> listOfElemThatWeNeed= new LinkedList<>();
        try {
            int parseInt = Integer.parseInt(note);
            double parseDouble = Double.parseDouble(note);
            vouchers.forEach(voucher -> {
                final boolean find;
                if (parseInt == voucher.getId()) {
                    find = true;
                } else if (parseDouble == voucher.getCost()) {
                    find = true;
                } else if (note.equals(voucher.getDestination())) {
                    find = true;
                } else if (parseInt == voucher.getTripLength()) {
                    find = true;
                } else if (note.equals(voucher.getTransport())) {
                    find = true;
                } else if (note.equals(voucher.getSupply())) {
                    find = true;
                } else find = false;
                if (find) {
                    listOfElemThatWeNeed.add(voucher);
                }

            });

        } catch (NumberFormatException e) {
            vouchers.forEach(voucher -> {
                final boolean find;
                if (note.equals(voucher.getDestination())) {
                    find = true;
                } else if (note.equals(voucher.getTransport())) {
                    find = true;
                } else if (note.equals(voucher.getSupply())) {
                    find = true;
                } else find = false;
                if (find) {
                    listOfElemThatWeNeed.add(voucher);
                }
            });

        }
    return listOfElemThatWeNeed;
    }

    public List<TravelVoucher> findNotes(String left,String right,List<TravelVoucher> vouchers) {
        List<TravelVoucher> listOfElemThatWeNeed= new LinkedList<>();
        try {
            int parseIntLeft = Integer.parseInt(left);
            int parseIntRight = Integer.parseInt(right);
            double parseDoubleLeft = Double.parseDouble(left);
            double parseDoubleRight= Double.parseDouble(right);
            vouchers.forEach(voucher -> {
                final boolean find;
                if (parseIntLeft <= voucher.getId() && parseIntRight >= voucher.getId()) {
                    find = true;
                } else if (parseDoubleLeft <= voucher.getCost()&&parseDoubleRight >= voucher.getCost()) {
                    find = true;
                } else if (left.compareTo(voucher.getDestination())>=0&&right.compareTo(voucher.getDestination())<=0) {
                    find = true;
                } else if (parseIntLeft <= voucher.getTripLength()&&parseIntRight >= voucher.getTripLength()) {
                    find = true;
                } else if (left.compareTo(voucher.getTransport())>=0&&right.compareTo(voucher.getTransport())<=0) {
                    find = true;
                } else if (left.compareTo(voucher.getSupply())>=0&&right.compareTo(voucher.getSupply())<=0) {
                    find = true;
                } else find = false;
                if (find) {
                    listOfElemThatWeNeed.add(voucher);
                }

            });

        } catch (NumberFormatException e) {
            vouchers.forEach(voucher -> {
                final boolean find;
                if (left.compareTo(voucher.getDestination())<=0&&right.compareTo(voucher.getDestination())>=0) {
                    find = true;
                } else if (left.compareTo(voucher.getTransport())<=0&&right.compareTo(voucher.getTransport())>=0) {
                    find = true;
                } else if (left.compareTo(voucher.getSupply())<=0&&right.compareTo(voucher.getSupply())>=0) {
                    find = true;
                } else find = false;
                if (find) {
                    listOfElemThatWeNeed.add(voucher);
                }
            });

        }
        return listOfElemThatWeNeed;
    }

}
