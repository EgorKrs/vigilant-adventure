package com.loneless.fifth_task.data_handler;

import com.loneless.fifth_task.data.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CustomersBase {
    private List<Customer> customerList;
    private final AtomicLong uniqueId =new AtomicLong();
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

    public AtomicLong getUniqueId() {
        return uniqueId;
    }
    public long getId(){
        return uniqueId.incrementAndGet();
    }
    public void sort(){
        customerList.sort(Comparator.comparing(Customer::getName));
    }

    public List<Customer>getCustomersInCreditInterval(List<Customer> customers,long left,long right){
        if(left<right) {
            for (Customer aCustomerList : customerList) {
                if (aCustomerList.getCreditCardNumber() > left && aCustomerList.getCreditCardNumber() < right) {
                    customers.add(aCustomerList);
                }
            }
        }
        return customers;
    }

    public void setDefaultCustomerBase(){
        Customer customer=new Customer(uniqueId.incrementAndGet(),"surname","La","patronymic","address",111111,111111);
        customerList.add(customer);
        customer=new Customer(uniqueId.incrementAndGet(),"surname","AL","patronymic","address",222222,222222);
        customerList.add(customer);
        customer=new Customer(uniqueId.incrementAndGet(),"surname","Na","patronymic","address",333333,333333);
        customerList.add(customer);
    }


}
