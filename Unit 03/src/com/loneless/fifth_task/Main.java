package com.loneless.fifth_task;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListOfCustomers base=new ListOfCustomers();
        setDefaultCustomerBase(base);
        CustomersListLogic handler=new CustomersListLogic();
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter\n1 to add new customer\n2 to see customers\n3 to sort customers\n" +
                        "4 to find customers credit card into Interval\n" +
                       "-1 to exit");
                switch (scanner.nextInt()) {
                    case -1:
                        return;
                    case 1:
                        scanner.skip(".*\n");
                        Customer customer=new Customer();
                        customer.setId(base.getId());
                        System.out.println("Enter customer surname");
                        customer.setSurname(scanner.nextLine());
                        System.out.println("Enter customer name");
                        customer.setName(scanner.nextLine());
                        System.out.println("Enter customer patronymic");
                        customer.setPatronymic(scanner.nextLine());
                        System.out.println("Enter customer address");
                        customer.setAddress(scanner.nextLine());
                        System.out.println("Enter customer credit card number");
                        customer.setCreditCardNumber(scanner.nextLong());
                        System.out.println("Enter customer bank account number");
                        customer.setBankAccountNumber(scanner.nextLong());
                        base.add(customer);
                        break;
                    case 2:
                        System.out.println("\n");
                        for(int i = 0; i<base.getCustomers().size(); i++){
                            System.out.println(base.getCustomers().get(i).toString());
                        }
                        System.out.println("\n");
                        break;
                    case 3:
                        handler.sort(base.getCustomers());
                        System.out.println("\n");
                        for(int i = 0; i<base.getCustomers().size(); i++){
                            System.out.println(base.getCustomers().get(i).toString());
                        }
                        System.out.println("\n");
                        break;
                    case 4:
                        List<Customer> customers;
                        System.out.println("inter interval of value");
                        customers=handler.getCustomersInCreditInterval(scanner.nextLong(),scanner.nextLong(),base.getCustomers());
                        if(customers.size()!=0) {
                            for (Customer customerInInterval :
                                    customers) {
                                System.out.println(customerInInterval.toString());
                            }
                        }
                        else System.out.println("There no customers that you are looking for");

                        break;
                    case 5:
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Enter a valid beans");
                scanner.skip(".*\n");
            }
        } while (true);
    }
    private static void setDefaultCustomerBase(ListOfCustomers base){
        Customer customer=new Customer(base.getId(),"surname","La","patronymic","address",111111,111111);
        base.getCustomers().add(customer);
        customer=new Customer(base.getId(),"surname","AL","patronymic","address",222222,222222);
        base.getCustomers().add(customer);
        customer=new Customer(base.getId(),"surname","Na","patronymic","address",333333,333333);
        base.getCustomers().add(customer);
    }
}
