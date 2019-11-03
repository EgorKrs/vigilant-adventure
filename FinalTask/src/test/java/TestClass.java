import com.loneless.PathManager;
import com.loneless.controller.CommandProvider;
import com.loneless.dao.DAOExeption;
import com.loneless.dao.FactoryDAO;
import com.loneless.entity.Category;
import com.loneless.entity.Transaction;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.DataGenerator;
import com.loneless.service.Logic;
import com.loneless.view.Demo;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public  class TestClass {
    @Test  public void addTransaction(){
        Demo demo=new Demo();
        Transaction transaction0;
        for(int i=0;i<4;i++) {
            transaction0 = new Transaction();
            transaction0 = demo.createDefaultTransaction();
            TransactionWhipper.getInstance().getTransactions().add(transaction0);
        }

        Assert.assertNotNull(TransactionWhipper.getInstance().getTransactions());
    }
    @Test  public  void deleteTransaction(){
        Demo demo=new Demo();
        Transaction transaction=demo.createDefaultTransaction();
        Logic.getInstance().removeTransactionByID(TransactionWhipper.getInstance(),transaction.getID());
        Assert.assertEquals(Logic.getInstance().receiveTransactionByID(TransactionWhipper.getInstance().
                getTransactions(),transaction.getID()).getID(),0);
    }
    @Test public  void updateTransaction(){
        Demo demo=new Demo();
        Transaction transaction=demo.createDefaultTransaction();
        int oldHAch=transaction.hashCode();
        transaction.setID(-10);
        Assert.assertNotEquals(oldHAch,transaction.hashCode());
    }
    @Test public void receiveAllTransaction(){
        Assert.assertNotEquals(Logic.getInstance().findAllPlannedTransaction(TransactionWhipper.getInstance().
                getTransactions()).size(),0);
    }
    @Test public  void save() throws DAOExeption {
        TransactionWhipper.getInstance().getTransactions().clear();
        FactoryDAO.getFileWorker().readObject(PathManager.getInstance().getTransactionData());
        Assert.assertNotEquals(TransactionWhipper.getInstance().getTransactions().size(),0);
    }

}
