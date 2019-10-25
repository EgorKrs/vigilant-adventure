package com.loneless.view;

import com.loneless.entity.Transaction;
import com.loneless.entity.UserPrivateData;
import com.loneless.service.DataGenerator;
import com.loneless.service.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

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

    public void startMenu() throws IOException {
        while (true){
            System.out.println("Введите\n1 для работы с вашими транзакцией\n2 для просмота транзакций в интервале\n" +
                    "3 для просмотра нераспределенных финансов\n4 для просмотра плановых транзакций\n-1 для выхода");
            switch (checkEnter(4)){
                case -1:
                    return;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
            System.out.println("Введите сумму транзакции");
            transaction.setSum(Validation.getInstance().receiveBigDecimalFromString(reader.readLine()));
            System.out.println("Выберите категорию из предложенных");
            String category = reader.readLine();
            if (Validation.getInstance().isSuchCategoryExist(category))
                transaction.setCategory(category.toUpperCase());
            else {
                System.out.println("Не верная категория");
            }
            System.out.println("Введите дату в формате dd-MMM-yyyy:HH:mm");
            String data = reader.readLine();
            LocalDate date;
            if ((date = Validation.getInstance().validData(data)) != null)
                transaction.setDate(date);
            else {
                System.out.println("Не верная дата");
            }
            System.out.println("Введите true если эта транзакция является плановой");
            transaction.setPlanned(Boolean.valueOf(reader.readLine()));
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

}
