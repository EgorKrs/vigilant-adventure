package com.loneless.fifth_task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomersBase {
    private List<Customer> customerList;
    public CustomersBase(){
        customerList=new ArrayList<>();
    }
    public CustomersBase(ArrayList<Customer> customers) {
        customerList = customers;
    }
    public List<Customer> getCustomerList() {
        return customerList;
    }
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    public void sort(){
        customerList.sort(Comparator.comparing(Customer::getName));
    }
    public List<Customer>getCustomersInCreditInterval(long left,long right){
        List<Customer> customers=new ArrayList<>();
        for (Customer aCustomerList : customerList) {
            if (aCustomerList.getCreditCardNumber() > left && aCustomerList.getCreditCardNumber() < right) {
                customers.add(aCustomerList);
            }
        }
        return customers;
    }

}
