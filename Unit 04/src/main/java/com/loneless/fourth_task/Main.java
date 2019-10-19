package com.loneless.fourth_task;

import com.loneless.DataGenerator;
import com.loneless.fourth_task.entity.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static List<TravelVoucher> vouchers = new LinkedList<>();
    private static AtomicInteger id = new AtomicInteger();

    public static void main(String[] args) {
        addSomeNotes(vouchers);
        View view = new View(id);
        view.menu(vouchers);
    }
    private static void addSomeNotes(List<TravelVoucher> vouchers) {
        for (int i = 0; i < 5; i++) {
            TravelVoucher voucher;
            switch (DataGenerator.getInstance().getRandom().nextInt(4)) {
                case 0:
                    voucher = new Recreation();
                    break;
                case 1:
                    voucher = new Excursion();
                    break;
                case 2:
                    voucher = new Treatment();
                    break;
                case 3:
                    voucher = new Shopping();
                    break;
                case 4:
                    voucher = new Cruise();
                    break;
                default:
                    voucher = new Cruise();
                    break;
            }

            voucher.setDestination((String) voucher.receivePossibleDestination()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleDestination().length - 1)]);

            voucher.setTripLength(voucher.receivePossibleLength()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleLength().length - 1)]);

            voucher.setTransport((String) voucher.receivePossibleTransport()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleTransport().length - 1)]);

            voucher.setSupply((String) voucher.receivePossibleSupply()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleSupply().length - 1)]);
            voucher.setId(id.getAndIncrement());
            vouchers.add(voucher);
        }
    }
}
