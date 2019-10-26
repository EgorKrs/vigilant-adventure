package com.loneless.view;

import com.loneless.controller.CommandProvider;
import com.loneless.entity.Category;
import com.loneless.entity.Transaction;
import com.loneless.entity.UserPrivateData;
import com.loneless.service.DataGenerator;
import com.loneless.service.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Menu {

    private static final Menu instance=new Menu();

    public static Menu getInstance() {
        return instance;
    }

    private BufferedReader reader;

    public Menu(){
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public void setReader(BufferedReader reader){
        this.reader=reader;
    }

    public void startMenu() throws IOException, ClassNotFoundException {
        while (true){
            System.out.println("Введите\n1 для работы с вашими транзакцией\n2 для просмота транзакций в интервале\n" +
                    "3 для просмотра остатков финансов\n4 для просмотра плановых транзакций\n-1 для выхода");
            switch (checkEnter(4)){
                case -1:
                    return;
                case 1:
                    workWithTransaction();
                    break;
                case 2:
                    chooseInterval();
                    break;
                case 3:
                    CommandProvider.getCommandProvider().getCommand("CALCULATE_CURRENT_SUM").execute();
                    break;
                case 4:
                    CommandProvider.getCommandProvider().getCommand("Receive Planned Transaction").execute();
                    break;
                    default:
                        System.out.println("Не верный выбор");
            }        }
    }

    private int checkEnter(int possibleLength) throws IOException {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(reader.readLine());
                if (choice <= possibleLength) {
                    return choice;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Введите целое число не больше "+possibleLength);
            }
        }
    }

    public UserPrivateData authorisation() throws IOException {
        UserPrivateData userPrivateData=new UserPrivateData();
        System.out.println("Введите логин");
        userPrivateData.setLogin(reader.readLine());
        System.out.println("Введите пароль");
        userPrivateData.setPassword(reader.readLine());
        return  userPrivateData;
    }

    public Transaction receiveDataForTransaction() throws IOException {
        Transaction transaction=null;
        while (!Validation.getInstance().isTransactionValid(transaction)) {
            System.out.println("Введите допустимую транзакцию");
            transaction=new Transaction();
            transaction.setID(DataGenerator.getUniTrID());
            enterSum(transaction);
            enterCategory(transaction);
            enterData(transaction);
            enterPlaned(transaction);
        }
        return transaction;
    }

    public Transaction receiveTransactionToFind() throws IOException {
        Transaction transaction =null;
        while (Validation.getInstance().isTransactionNull(transaction)) {
            transaction = new Transaction();
            System.out.println("Хотя бы 1 поле транзакции должно быть введено");
            System.out.println("Введите данные транзакции которую хотите найти");
            System.out.println("Введите ID");
            String data = reader.readLine();
            if (data != null || data.length() != 0) {
                transaction.setID(Integer.parseInt(data));
            }
            System.out.println("Введите сумму транзакции");
            data = reader.readLine();
            if (data != null || data.length() != 0) {
                transaction.setSum(Validation.getInstance().receiveBigDecimalFromString(reader.readLine()));
            }
            System.out.println("Выберите категорию из предложенных");
            data = reader.readLine();
            if (data != null || data.length() != 0) {
                if (Validation.getInstance().isSuchCategoryExist(data))
                    transaction.setCategory(data.toUpperCase());
                else {
                    System.out.println("Не верная категория");
                }
            }
            System.out.println("Введите дату в формате dd-MMM-yyyy:HH:mm");
            data = reader.readLine();
            if (data != null || data.length() != 0) {
                LocalDate date;
                if ((date = Validation.getInstance().validData(data)) != null)
                    transaction.setDate(date);
                else {
                    System.out.println("Не верная дата");
                }
            }
            data = reader.readLine();
            if (data != null || data.length() != 0) {
                System.out.println("Введите true если эта транзакция является плановой");
                transaction.setPlanned(Boolean.valueOf(reader.readLine()));
            }
        }
        return transaction;
    }

    public Transaction chooseTransactionFromList(List<Transaction> transactions) throws IOException {
        System.out.println("Выберите транзацию по ID");
        for (Transaction transaction :
                transactions) {
            System.out.println(transaction);
        }
        int id=-1;
        while (id<0) {
            System.out.println("Введите ID");
            id = Integer.parseInt(reader.readLine());
        }
        for (Transaction transaction :
                transactions) {
            if(transaction.getID()==id){
                return transaction;
            }
        }
        return null;
    }

    private boolean enterPlaned(Transaction transaction) throws IOException {
        System.out.println("Введите true если эта транзакция является плановой");
        transaction.setPlanned(Boolean.valueOf(reader.readLine()));
        return true;
    }

    private boolean enterCategory(Transaction transaction) throws IOException {
        boolean ok=false;
        System.out.println("Выберите категорию из предложенных");
        System.out.println(Arrays.toString(Category.values()));
        String category = reader.readLine();
        if (Validation.getInstance().isSuchCategoryExist(category)) {
            transaction.setCategory(category.toUpperCase());
            ok=true;
        }
        else {
            System.out.println("Не верная категория");
        }
        return ok;
    }

    private boolean enterData(Transaction transaction) throws IOException {
        boolean ok=false;
        System.out.println("Введите дату в формате dd-MMM-yyyy:HH:mm");
        String data = reader.readLine();
        LocalDate date;
        if ((date = Validation.getInstance().validData(data)) != null) {
            transaction.setDate(date);
            ok=true;
        }
        else {
            System.out.println("Не верная дата");
        }
        return ok;
    }

    private boolean enterSum(Transaction transaction) throws IOException {
        System.out.println("Введите сумму транзакции");
        transaction.setSum(Validation.getInstance().receiveBigDecimalFromString(reader.readLine()));
        return true;
    }

    public Transaction editTransaction(Transaction transaction) throws IOException {
        System.out.println("Введите\n1 для редактирования даты\n2 для редактирования категории\n" +
                "3 для редактирования суммы\n4 для редактирования запланированности");
        switch (checkEnter(4)){
            case 1:
                enterData(transaction);
                break;
            case 2:
                enterCategory(transaction);
                break;
            case 3:
                enterSum(transaction);
                break;
            case 4:
                enterPlaned(transaction);
                break;
                default:
                    System.out.println("Неверный выбор");
        }
        return transaction;
    }

    public void printAllTransaction(List<Transaction> transactions){
        for (Transaction transaction :
                transactions) {
            System.out.println(transaction);
        }
    }

    public void printError(String error){
        System.out.println(error);
    }

    private void workWithTransaction() throws IOException, ClassNotFoundException {

        while (true){
            System.out.println("Введите\n1 для добавления транзакциии\n2 для просмота всех транзакций\n" +
                    "3 для удаления транзакций\n4 редактирования транзакции\n-1 для выхода");
            switch (checkEnter(4)){
                case -1:
                    return;
                case 1:
                    CommandProvider.getCommandProvider().getCommand("ADD_TRANSACTION").execute();
                    break;
                case 2:
                    CommandProvider.getCommandProvider().getCommand("GET_ALL_TRANSACTION").execute();
                    break;
                case 3:
                    CommandProvider.getCommandProvider().getCommand("DELETE_TRANSACTION").execute();
                    break;
                case 4:
                    CommandProvider.getCommandProvider().getCommand("UPDATE_TRANSACTION").execute();
                    break;
                default:
                    System.out.println("Не верный выбор");
            }
        }
    }

    public void printCurrentSum(BigDecimal sum){
        System.out.println("Текущий баланс: "+sum.toString());
    }

    public LocalDate askAboutDate() throws IOException {
        System.out.println("Введите дату в формате dd-MMM-yyyy:HH:mm");
        return Validation.getInstance().validData(reader.readLine());
    }

    private void chooseInterval() throws IOException, ClassNotFoundException {
        System.out.println("Введите\n1 для поиска до текущей даты\n2 для поиска до произвольной даты");
        switch (checkEnter(2)){
            case 1:
                CommandProvider.getCommandProvider().getCommand("FIND_OLL_TRANSACTION_TO_CURRENT_DATE").execute();
                break;
            case 2:
                CommandProvider.getCommandProvider().getCommand("FIND_OLL_TRANSACTION_IN_INTERVAL").execute();
                break;
            default:
                System.out.println("Не верный выбор");
        }
    }
}
