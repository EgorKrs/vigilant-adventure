package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.view.Menu;



public class CalculateCurrentSum implements Command {
    @Override
    public boolean execute()  {
        Menu.getInstance().printCurrentSum(Logic.getInstance().countSumOfMoney(TransactionWhipper.getInstance()));
        return true;
    }
}
