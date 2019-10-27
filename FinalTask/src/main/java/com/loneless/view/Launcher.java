package com.loneless.view;

import com.loneless.controller.CommandProvider;
import com.loneless.controller.ControllerException;

import java.io.IOException;


public class Launcher {
    public static void main(String[] args) throws ViewException, IOException {
        //Demo demo=new Demo();
        //demo.defaultTransactionAddToFile(TransactionWhipper.getInstance());//снять коментарий для того что бы создать данные по умолчанию
        //System.out.println(FactoryDAO.getFileWorker().readObject(new UserPrivateData(),"userData.txt"));
        //System.out.println("login='Dwayne Pipe', password='2555639bc2a23419366ea61a1e5892e0fc9efba'");
        while (true) {
            Menu menu = new Menu();
            try {
                if (CommandProvider.getCommandProvider().getCommand("AUTHORISE_USER").execute()) {
                    menu.startMenu();
                    CommandProvider.getCommandProvider().getCommand("Save_Transactions").execute();
                    break;
                }
                else System.out.println("Не верные данные");
            } catch (ControllerException e) {
                System.out.println(e.getException());
            }
            finally {
                menu.getReader().close();
            }
        }
    }
}
