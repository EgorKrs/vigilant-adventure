package com.loneless.third_task;

import com.loneless.third_task.accounts.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Client {
    private int id;
    private String[] fullName;
    private List<Account> accounts=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getFullName() {
        return fullName;
    }

    public void setFullName(String[] fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName=" + Arrays.toString(fullName) +
                ", accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Arrays.equals(fullName, client.fullName) &&
                Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, accounts);
        result = 31 * result + Arrays.hashCode(fullName);
        return result;
    }

    public boolean addAccount(){
        return true;// true если нет заблокированных аккаунтов
    }
}
