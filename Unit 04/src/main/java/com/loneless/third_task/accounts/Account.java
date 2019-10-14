package com.loneless.third_task.accounts;


import com.loneless.third_task.Client;

import java.util.Objects;

public abstract class Account implements Comparable<Account>{// абстрактный счет в котором есть данные и методы для любого счёта
    protected int id;
    protected Client host;
    protected long balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getHost() {
        return host;
    }

    public void setHost(Client host) {
        this.host = host;
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
                Objects.equals(host, account.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, host, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", host=" + host +
                ", balance=" + balance +
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
