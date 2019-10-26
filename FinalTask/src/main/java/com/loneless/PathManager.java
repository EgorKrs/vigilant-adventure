package com.loneless;


public class PathManager {

    private static PathManager instance = new PathManager();

    public static PathManager getInstance() {
        return instance;
    }

    private PathManager() {
    }

    private String userData="Data\\UserData.txt" ;

    private String transactionData="Data\\TransactionData.txt";

    public String getUserData() {
        return userData;
    }

    public String getTransactionData() {
        return transactionData;
    }
}
