package com.loneless.third_task.entity;


import java.util.Objects;

public  class Account implements Comparable<Account>{
    private int id;
    private long balance;
    private boolean block;

    public Account() {
    }

    public Account(int id, long balance, boolean block) {
        this.id = id;
        this.balance = balance;
        this.block = block;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                balance == account.balance &&
                block == account.block;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, block);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", block=" + block +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        if(balance==o.balance)
            return 0;
        else if(balance-o.balance>0){
            return 1;
        }
        else {
            return -1;
        }
    }

}
