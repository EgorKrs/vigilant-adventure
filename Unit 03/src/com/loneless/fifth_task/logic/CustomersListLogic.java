package com.loneless.fifth_task.logic;

import com.loneless.fifth_task.beans.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomersListLogic {
    public List<Customer> getCustomersInCreditInterval(long left, long right,List<Customer> customers){
        List<Customer> customersInInterval=new ArrayList<>();
        if(left<right) {
            for (Customer customer : customers) {
                if (customer.getCreditCardNumber() > left && customer.getCreditCardNumber() < right) {
                    customersInInterval.add(customer);
                }
            }
        }
        return customersInInterval;
    }
    public void sort(List<Customer> customers){
        customers.sort(Comparator.comparing(Customer::getName));
    }
}
