package com.loneless.third_task;
import com.loneless.third_task.entity.Account;
import com.loneless.third_task.entity.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BankLogic {

    private static final BankLogic instance = new BankLogic();

    public static BankLogic getInstance() {
        return instance;
    }

    public long findSumOfAllAccounts(Client client) {
        long sum = 0;
        for (Account account :
                client.getAccounts()) {
            if (!account.isBlock())
                sum += account.getBalance();
        }
        return sum;
    }

    public long findSumOfPositivaAccounts(Client client) {
        long sum = 0;
        for (Account account :
                client.getAccounts()) {
            if (!account.isBlock() && account.getBalance() > 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public long findSumOfNegativeAccounts(Client client) {
        long sum = 0;
        for (Account account :
                client.getAccounts()) {
            if (!account.isBlock() && account.getBalance() < 0) {
                sum -= account.getBalance();
            }
        }
        return sum;
    }

    public void sortAccounts(Client client) {
        Collections.sort(client.getAccounts());
    }

    public List<Account> findNotes(String note, List<Account> accounts) {
        List<Account> listOfElemThatWeNeed= new ArrayList<>();
        try {
            int parseInt = Integer.parseInt(note);
            long parseLong=Long.parseLong(note);
            accounts.forEach(account -> {
                final boolean find;
                if (parseInt == account.getId()) {
                    find = true;
                } else find = parseLong == account.getBalance();
                if (find) {
                    listOfElemThatWeNeed.add(account);
                }

            });

        } catch (NumberFormatException e) {
            // не знаю как обработать. По идее его достаточно просто погасить т.к если на выходе пустой список
            // то очевидно что таких данных нет и это вроде как норм
        }
        return listOfElemThatWeNeed;
    }

    public List<Account> findNotes(String left,String right,List<Account> accounts) {
        List<Account> listOfElemThatWeNeed= new ArrayList<>();
        try {
            int parseIntLeft = Integer.parseInt(left);
            int parseIntRight = Integer.parseInt(right);
            double parseLongLeft = Double.parseDouble(left);
            double parseLongRight= Double.parseDouble(right);
            accounts.forEach(account -> {
                final boolean find;
                if (parseIntLeft <= account.getId() && parseIntRight >= account.getId()) {
                    find = true;
                }
                else find =parseLongLeft <= account.getBalance()&&parseLongRight >= account.getBalance();
                if (find) {
                    listOfElemThatWeNeed.add(account);
                }

            });

        } catch (NumberFormatException e) {
            // не знаю как обработать. По идее его достаточно просто погасить т.к если на выходе пустой список
            // то очевидно что таких данных нет и это вроде как норм
        }
        return listOfElemThatWeNeed;
    }
}

