package com.loneless.fourth_task;

import com.loneless.fourth_task.travel_vouchers.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<TravelVoucher> vouchers=new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в " + DataGenerator.getInstance().getFaker().company().name() +
                ". Мы рады помочь в выборе вашей путевки в мир рандомных чудес");
        System.out.println("Введите \n1 для создания новой путевки\n2 для сортировки путевок");
        switch (validChoice(scanner,4)){
            case 1:
                addVoucher(scanner);
                break;
            case 2:
                System.out.println("Для сортировки по критерию введите\n1  id\n2  supply\n3 transport\n" +
                        "4 tripLength\n5 cost\n6 destination");
                TravelVoucherLogic.getInstance().sort(scanner.nextLine(),vouchers);
            case 3:

                break;
        }




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
                scanner.skip(".*\n");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введите допустимое число");
                scanner.skip(".*\n");
            }
        return choice;
    }

    private static void addVoucher(Scanner scanner){
        TravelVoucher voucher;
        boolean correctEnterData = false;
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
            default:voucher=null;
                break;
        }


        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите одно из возможных мест для поездки");
            System.out.println(Arrays.deepToString(voucher.receivePossibleDestination()));
            if (!(correctEnterData = voucher.setDestination(scanner.nextLine()))) {
                System.out.println("Нет такого пункта назначения");
            }
        }

        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите одну из возможных продолжительностей поездки");
            System.out.println(Arrays.toString(voucher.receivePossibleLength()));
            if (!(correctEnterData = voucher.setTripLength(Integer.parseInt(scanner.nextLine())))) {
                System.out.println("НЕт такой продолжительности поездки");
            }
        }

        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите один из предложенных транспортов");
            System.out.println(Arrays.toString(voucher.receivePossibleTransport()));
            if (!(correctEnterData = voucher.setTransport(scanner.nextLine()))) {
                System.out.println("Нет такого транспорта");
            }
        }

        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите один из предложенных вариантов еды");
            System.out.println(Arrays.toString(voucher.receivePossibleSupply()));
            if (!(correctEnterData = voucher.setSupply(scanner.nextLine()))) {
                System.out.println("Нет такой еды");
            }
        }
        System.out.println("Ваш выбор:");
        System.out.println("Вид поездки: "+ voucher.getClass().getName()+"\nПункт назначения: "+voucher.getDestination()+
                "\nПродолжительность: "+voucher.getTripLength() +"\nТранспорт: "+voucher.getTransport()+
                "\nЕда: "+voucher.getSupply());
        vouchers.add(voucher);
    }
}
