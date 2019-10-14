package com.loneless.third_task.accounts;

public class PositiveAccount extends Account {
    // условно может как брать кредиты так и отдавать их
    public boolean isALoanPossible(){
        // true если баланс счета позволяет ее выплатьть
        return true;
    }


}
