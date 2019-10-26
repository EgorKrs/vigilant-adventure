package com.loneless.view;

import com.loneless.controller.CommandProvider;
import com.loneless.controller.ControllerException;
import com.loneless.dao.DAOExeption;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Demo;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;


import java.io.*;


public class Launcher {
    public static void main(String[] args) throws ViewException, ControllerException, IOException, DAOExeption {
        Demo demo=new Demo();
        //demo.defaultTransactionAddToFile(TransactionWhipper.getInstance());//снять коментарий для того что бы создать данные по умолчанию
        Menu menu=new Menu();

        menu.startMenu();
        CommandProvider.getCommandProvider().getCommand("Save_Transactions").execute();
    }
}
