package com.loneless.view;

import com.loneless.controller.CommandProvider;
import com.loneless.controller.ControllerException;
import com.loneless.entity.Category;
import com.loneless.entity.Transaction;
import com.loneless.entity.UserPrivateData;
import com.loneless.service.DataGenerator;
import com.loneless.service.ServiceException;
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

    public void startMenu() throws  ViewException {

        while (true) {
            try {
                System.out.println("Введите\n1 для работы с вашими транзакцией\n2 для просмота транзакций в интервале\n" +
                        "3 для просмотра остатков финансов\n4 для просмотра плановых транзакций\n-1 для выхода");
                switch (checkEnter(4)) {
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
                }
            } catch (ControllerException e) {
                System.out.println(e.getException());
            }

        }
    }

    private int checkEnter(int possibleLength) throws ViewException {
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
            } catch (IOException e) {
                throw new ViewException("Ошибка в работе  BufferedReader "+e.getMessage());
            }

        }
    }

    public UserPrivateData authorisation() throws ViewException {
        try {
            System.out.println("Добро пожаловать. Авторизуйтесь для продолжения");
            UserPrivateData userPrivateData = new UserPrivateData();
            System.out.println("Введите логин");
            userPrivateData.setLogin(reader.readLine());
            System.out.println("Введите пароль");
            userPrivateData.setPassword(reader.readLine());
            return userPrivateData;
        }
        catch (IOException e) {
            throw new ViewException("Ошибка в работе  BufferedReader "+e.getMessage());
        }
    }

    public Transaction receiveDataForTransaction() throws  ViewException {
        try {
            while (true) {
                System.out.println("Введите транзакцию");
                Transaction transaction = new Transaction();
                transaction.setID(DataGenerator.getUniTrID());
                enterSum(transaction);
                enterCategory(transaction);
                enterData(transaction);
                enterPlaned(transaction);
                return transaction;
            }
        }
         catch (IOException e) {
            throw new ViewException("Ошибка в работе  BufferedReader "+e.getMessage());
        }

    }

    private boolean enterPlaned(Transaction transaction) throws IOException {
        System.out.println("Введите true если эта транзакция является плановой");
        transaction.setPlanned(Boolean.valueOf(reader.readLine()));
        return true;
    }

    private boolean enterCategory(Transaction transaction) throws IOException {
        boolean incorrectInput=true;
        while (incorrectInput) {
            System.out.println("Выберите категорию из предложенных");
            System.out.println(Arrays.toString(Category.values()));
            String category = reader.readLine().toUpperCase();
            if (Validation.getInstance().isSuchCategoryExist(category)) {
                transaction.setCategory(category);
                incorrectInput = false;
            } else {
                System.out.println("Не верная категория");
            }
        }
        return incorrectInput;
    }

    private boolean enterData(Transaction transaction) throws IOException {
       while (true) {
           try {
               System.out.println("Введите дату в формате dd-MMM-yyyy:HH:mm");
               String data = reader.readLine();
               LocalDate date;
               date = Validation.getInstance().validData(data);
               transaction.setDate(date);
               return true;
           }
           catch (ServiceException e){
               System.out.println(e.getException());
               System.out.println("Для продолжения введите корректную дату");
           }
       }
    }

    private boolean enterSum(Transaction transaction) throws IOException, ViewException {
        System.out.println("Введите сумму транзакции");
        try {
            transaction.setSum(Validation.getInstance().receiveBigDecimalFromString(reader.readLine()));
        } catch (ServiceException e) {
            throw new ViewException("Сумма введена некорректно "+e.getException());
        }
        return true;
    }
    public int receiveID() throws ViewException {
        while (true) {
            try {
                System.out.println("Введите ID");
                return Integer.parseInt(reader.readLine());
            } catch (java.lang.NumberFormatException e){
                System.out.println("Введите числовой ID");
            }
            catch (IOException e) {
                throw new ViewException("Ошибка в работе  BufferedReader "+e.getMessage());
            }
        }
    }

    public Transaction editTransaction(Transaction transaction) throws  ViewException {
        while (true) {
            try {
                System.out.println("Введите\n1 для редактирования даты\n2 для редактирования категории\n" +
                        "3 для редактирования суммы\n4 для редактирования запланированности");
                switch (checkEnter(4)) {
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
            catch (IOException e) {
                throw new ViewException("Ошибка в работе  BufferedReader "+e.getMessage());
            }
        }
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

    private void workWithTransaction() throws ControllerException, ViewException {

        while (true){
            System.out.println("Введите\n1 для добавления транзакциии\n2 для просмота всех транзакций\n" +
                    "3 для удаления транзакций\n4 редактирования транзакции\n-1 для выхода");
            switch (checkEnter(4)){
                case -1:
                    return;
                case 1:
                    if(CommandProvider.getCommandProvider().getCommand("ADD_TRANSACTION").execute()){
                        System.out.println("Транзакция успешно добавлена");
                    }
                    else System.out.println("Невозможно добавить такую транзакцию");
                    break;
                case 2:
                    CommandProvider.getCommandProvider().getCommand("RECEIVE_ALL_TRANSACTION").execute();
                    break;
                case 3:
                    if( CommandProvider.getCommandProvider().getCommand("DELETE_TRANSACTION").execute()){
                        System.out.println("Тканзакция успешно удалена");
                    }
                    else System.out.println("Нет такой транзакции");
                    break;
                case 4:
                    if (CommandProvider.getCommandProvider().getCommand("UPDATE_TRANSACTION").execute()){
                        System.out.println("Тканзакция успешно изменена");
                    }
                    else System.out.println("Нет такой транзакции");
                    break;
                default:
                    System.out.println("Не верный выбор");
            }
        }
    }

    public void printCurrentSum(BigDecimal sum){
        System.out.println("Текущий баланс: "+sum.toString());
    }

    public LocalDate askAboutDate() throws  ViewException {
        System.out.println("Введите дату в формате dd-MMM-yyyy:HH:mm");
        try {
            return Validation.getInstance().validData(reader.readLine());
        } catch (ServiceException e) {
            throw new ViewException("Невеная дата "+e.getException());
        }
        catch (IOException e) {
            throw new ViewException("Ошибка в работе  BufferedReader "+e.getMessage());
        }
    }

    private void chooseInterval() throws  ControllerException, ViewException {
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
