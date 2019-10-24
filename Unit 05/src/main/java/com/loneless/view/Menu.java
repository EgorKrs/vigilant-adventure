package com.loneless.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private final BufferedReader reader;

    public Menu(){
        reader=new BufferedReader(new InputStreamReader(System.in));
    }
    Menu(BufferedReader reader){
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
}
