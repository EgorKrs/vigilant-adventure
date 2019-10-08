package com.loneless.fifth_task;

import com.loneless.fifth_task.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ListOfCustomers {
    private final AtomicLong uniqueId =new AtomicLong();
    private List<Customer> customers =new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList customers) {
        this.customers = customers;
    }

    public ListOfCustomers(){

    }
    public AtomicLong getUniqueId() {
        return uniqueId;
    }

    public long getId(){
        return uniqueId.incrementAndGet();
    }

    public boolean add(Customer customer){
        if(customer!=null) {
            customers.add(customer);
            return true;
        }
        else {
            return false;
        }
    }
}
