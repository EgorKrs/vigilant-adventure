package com.loneless.fourth_task;

import com.loneless.DataGenerator;
import com.loneless.fourth_task.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class View {
    private AtomicInteger id;

    public View(AtomicInteger id){
        this.id=id;
    }

    public void menu(List<TravelVoucher> vouchers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в " + DataGenerator.getInstance().getFaker().company().name() +
                ". Мы рады помочь в выборе вашей путевки в мир рандомных чудес");
        while (true) {
            System.out.println("Введите \n1 для создания новой путевки\n2 для сортировки путевок" +
                    "\n3 для просмотра всех записей\n4 для выборки данных\n5 для поиска в диапазоне\n-1 для выхода");
            switch (validChoice(scanner, 5)) {
                case -1:
                    return;
                case 1:
                    addVoucher(scanner,vouchers);
                    break;
                case 2:
                    System.out.println("Для сортировки по критерию введите\nid\nsupply\ntransport\n" +
                            "tripLength\ncost\ndestination");
                    TravelVoucherLogic.getInstance().sort(scanner.nextLine(), vouchers);
                    break;
                case 3:
                    for (TravelVoucher voucher :
                            vouchers) {
                        printVoucher(voucher);
                    }
                    break;
                case 4:
                    System.out.println("Введите данные для выборки");
                    printVoucher(TravelVoucherLogic.getInstance().findNotes(scanner.nextLine(),vouchers));
                    break;
                case 5:
                    System.out.println("Введите диапазон значений");
                    printVoucher(TravelVoucherLogic.getInstance().findNotes(scanner.nextLine(),scanner.nextLine(),vouchers));

            }
        }
    }
    private void printVoucher(TravelVoucher voucher) {
        System.out.print("\nID: " + voucher.getId() + "\nЦена: ");
        System.out.printf("%8.2f", voucher.getCost());
        System.out.println(" $\nПуть назначения: " +
                voucher.getDestination() + "\nДлинна путешествия: " + voucher.getTripLength() + " дн.\nТранспорт: " +
                voucher.getTransport() + "\nЕда: " + voucher.getSupply() + "\n");
    }

    private void printVoucher(List<TravelVoucher> vouchers) {
        for (TravelVoucher voucher :
                vouchers) {
            System.out.print("\nID: " + voucher.getId() + "\nЦена: ");
            System.out.printf("%8.2f", voucher.getCost());
            System.out.println(" $\nПуть назначения: " +
                    voucher.getDestination() + "\nДлинна путешествия: " + voucher.getTripLength() + " дн.\nТранспорт: " +
                    voucher.getTransport() + "\nЕда: " + voucher.getSupply() + "\n");
        }
    }

    private  int validChoice(Scanner scanner, int max) {
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

    private  TravelVoucher setTypeOfVoucher(TravelVoucher voucher,int type){
        switch (type) {
            case 1:
                voucher = new Recreation();
                break;
            case 2:
                voucher = new Excursion();
                break;
            case 3:
                voucher = new Treatment();
                break;
            case 4:
                voucher = new Shopping();
                break;
            case 5:
                voucher = new Cruise();
                break;
            default:
                voucher = null;
                break;
        }
        return voucher;
    }

    private  void setDestination(TravelVoucher voucher,Scanner scanner){
        boolean correctEnterData;
        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите одно из возможных мест для поездки");
            System.out.println(Arrays.deepToString(voucher.receivePossibleDestination()));
            if (!(correctEnterData = voucher.setDestination(scanner.nextLine()))) {
                System.out.println("Нет такого пункта назначения");
            }
        }
    }

    private  void setLength(TravelVoucher voucher,Scanner scanner) {
        boolean correctEnterData;

        for (correctEnterData = false; !correctEnterData; ) {
            try {
                System.out.println("Выберите одну из возможных продолжительностей поездки");
                System.out.println(Arrays.toString(voucher.receivePossibleLength()));
                if (!(correctEnterData = voucher.setTripLength(Integer.parseInt(scanner.nextLine())))) {
                    System.out.println("НЕт такой продолжительности поездки");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректная форма записи. Убедитесь в правильности написания");
            }
        }
    }

    private  void setTransport(TravelVoucher voucher,Scanner scanner){
        boolean correctEnterData;
        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите один из предложенных транспортов");
            System.out.println(Arrays.toString(voucher.receivePossibleTransport()));
            if (!(correctEnterData = voucher.setTransport(scanner.nextLine()))) {
                System.out.println("Нет такого транспорта");
            }
        }
    }

    private  void setSupply(TravelVoucher voucher,Scanner scanner){
        boolean correctEnterData;
        for (correctEnterData = false; !correctEnterData; ) {
            System.out.println("Выберите один из предложенных вариантов еды");
            System.out.println(Arrays.toString(voucher.receivePossibleSupply()));
            if (!(correctEnterData = voucher.setSupply(scanner.nextLine()))) {
                System.out.println("Нет такой еды");
            }
        }
    }

    private  void addVoucher(Scanner scanner,List<TravelVoucher> vouchers) {
        TravelVoucher voucher=null;

        System.out.println("Для начало выберите тип поездки:\n1 для отдыха\n2 для экскурсии\n3 для лечение\n" +
                "4 для  шопинга \n5 для круиза");
        voucher=setTypeOfVoucher(voucher,validChoice(scanner, 5));

        setDestination(voucher,scanner);

        setLength(voucher,scanner);

        setTransport(voucher,scanner);

        setSupply(voucher,scanner);

        System.out.print("\nВаш выбор:");
        voucher.setId(id.getAndIncrement());
        printVoucher(voucher);
        vouchers.add(voucher);
    }

}
