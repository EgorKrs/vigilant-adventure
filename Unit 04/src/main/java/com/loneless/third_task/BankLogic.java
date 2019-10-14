package com.loneless.third_task;


import java.util.Collections;


public class BankLogic{
    private static final BankLogic instance=new BankLogic();

    public static BankLogic getInstance() {
        return instance;
    }

    public boolean isHaveNegativeAccount(Client client){
        return false;
    }
    public long findSumOfAllAccounts(Client client){
        return 0;
    }
    public long findSumOfPositivaAccounts(Client client){
        return 0;
    }
    public long findSumOfNegativeAccounts(Client client){
        return 0;
    }
    public void sortAccounts(Client client){
        Collections.sort(client.getAccounts());
    }

}
