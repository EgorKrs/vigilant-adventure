package com.loneless.fourth_task;

import com.loneless.fourth_task.travel_vouchers.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelVoucher voucher;
        System.out.println("Добро пожаловать в " + DataGenerator.getInstance().getFaker().company().name() +
                ". Мы рады помочь в выборе вашей путевки в мир рандомных чудес");
        System.out.println("Для начало выберите тип поездки:\n1 для отдыха\n2 для экскурсии\n3 для лечение\n" +
                "4 для  шопинга \n5 для круиза");
        switch (validChoice(scanner,5)){
            case 1:
                voucher=new Recreation();
                break;
            case 2:
                voucher=new Excursion();
                break;
            case 3:
                voucher=new Treatment();
                break;
            case 4:
                voucher=new Shopping();
                break;
            case 5:
                voucher=new Cruise();
                break;
        }
        System.out.println("Выберите одно из возможных мест для поездки");
        // больше не смог(
// TODO: 14.10.2019 доделать демонстрацию работы проги на базовом уровне
        // TODO: 14.10.2019 сделать список поездок и работу с ним
    }

    private static int validChoice(Scanner scanner, int max) {
        int choice = -1;
        boolean err = true;
        while (err)
            try {
                choice = scanner.nextInt();
                if (choice <= max)
                    err = false;
                else {
                    System.out.println("Введите допустимое число");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введите допустимое число");
                scanner.skip(".*\n");
            }
        return choice;
    }
}
