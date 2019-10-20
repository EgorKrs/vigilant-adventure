package com.loneless.third_task;

import com.loneless.DataGenerator;
import com.loneless.third_task.entity.Account;
import com.loneless.third_task.entity.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger id=new AtomicInteger();
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Client client=addClient();
        addSomeNotes(client);
        while (true){
            System.out.println("Введите\n1 для просмотра счетов клиента\n2 для поиска счетов клиента\n" +
                    "3 для сортировки счетов\n4 для вычислении общей суммы по счетам" +
                    "\n5 для вычисления суммы по + счетам\n6 для вычисления суммы по - счетам\n7 для поиска в диапазоне" +
                    "\n-1 для выхода");
            switch (reader.readLine()){
                case "-1":
                    return;
                case"1":
                    for (Account account :
                            client.getAccounts()) {
                        System.out.println(account);
                    }
                    break;
                case "2":
                    System.out.println("Введите данные для поиска");
                    System.out.println(BankLogic.getInstance().findNotes(reader.readLine(),client.getAccounts()));
                    break;
                case "3":
                    BankLogic.getInstance().sortAccounts(client);
                    break;
                case "4":
                    System.out.println("Сумма по счетам: "+BankLogic.getInstance().findSumOfAllAccounts(client));
                    break;
                case "5":
                    System.out.println("Сумма по + счетам: "+ BankLogic.getInstance().findSumOfPositivaAccounts(client));
                    break;
                case "6":
                    System.out.println("Суммы по - счетам: "+BankLogic.getInstance().findSumOfNegativeAccounts(client));
                    break;
                case "7":
                    System.out.println("Введите диапазон значений");
                    System.out.println(BankLogic.getInstance().findNotes(reader.readLine(),reader.readLine(),client.getAccounts()));
                    break;
                    default:
                        System.out.println("НЕ верный выбор");
            }
        }
    }

    private static void addSomeNotes(Client client){
        Account account;
        for(int i=0;i<5;i++) {
            account = new Account(id.getAndIncrement(),DataGenerator.getInstance().getFaker().
                    number().numberBetween(-1000000L,1000000L),
                    DataGenerator.getInstance().getRandom().nextBoolean());
            client.addAccount(account);
        }
    }
    private static Client addClient(){
        Client client=new Client();
        client.setId(id.getAndIncrement());
        client.setFullName(DataGenerator.getInstance().getFaker().name().fullName());
        return client;
    }
}
