package com.loneless.fourth_task;

import com.loneless.fourth_task.entity.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static List<TravelVoucher> vouchers = new LinkedList<>();
    private static AtomicInteger id = new AtomicInteger();

    public static void main(String[] args) {
       View view=new View(id);
       view.menu(vouchers);
    }

}
