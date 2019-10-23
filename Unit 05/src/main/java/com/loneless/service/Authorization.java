package com.loneless.service;

import com.loneless.dao.WorkWithfile;
import com.loneless.entity.UserPrivateData;

import java.io.IOException;

public class Authorization {
    private static final Authorization instance=new Authorization();
    private Authorization(){}

    public static Authorization getInstance() {
        return instance;
    }
    public boolean isExist(UserPrivateData user) throws IOException, ClassNotFoundException {
        UserPrivateData existingUser=new UserPrivateData();
        existingUser=WorkWithfile.getInstance().readObject(existingUser,"authorization.txt");
        return existingUser.equals(user);
    }
}
