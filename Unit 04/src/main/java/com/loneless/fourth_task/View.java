package com.loneless.fourth_task;

import com.loneless.fourth_task.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class View {
    AtomicInteger id;

    View(AtomicInteger id){
        this.id=id;
    }

    public void menu(List<TravelVoucher> vouchers){
        Scanner scanner = new Scanner(System.in);
        addSomeNotes(vouchers);
        System.out.println("Добро пожаловать в " + DataGenerator.getInstance().getFaker().company().name() +
                ". Мы рады помочь в выборе вашей путевки в мир рандомных чудес");
        while (true) {
            System.out.println("Введите \n1 для создания новой путевки\n2 для сортировки путевок" +
                    "\n3 для просмотра всех записей\n4 для выборки данных\n-1 для выхода");
            switch (validChoice(scanner, 4)) {
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
                    takeSomeNotes(scanner.nextLine(),vouchers);
                    break;
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

    private void addSomeNotes(List<TravelVoucher> vouchers) {
        for (int i = 0; i < 5; i++) {
            TravelVoucher voucher;
            switch (DataGenerator.getInstance().getRandom().nextInt(4)) {
                case 0:
                    voucher = new Recreation();
                    break;
                case 1:
                    voucher = new Excursion();
                    break;
                case 2:
                    voucher = new Treatment();
                    break;
                case 3:
                    voucher = new Shopping();
                    break;
                case 4:
                    voucher = new Cruise();
                    break;
                default:
                    voucher = new Cruise();
                    break;
            }

            voucher.setDestination((String) voucher.receivePossibleDestination()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleDestination().length - 1)]);

            voucher.setTripLength(voucher.receivePossibleLength()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleLength().length - 1)]);

            voucher.setTransport((String) voucher.receivePossibleTransport()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleTransport().length - 1)]);

            voucher.setSupply((String) voucher.receivePossibleSupply()
                    [DataGenerator.getInstance().getRandom().nextInt(voucher.receivePossibleSupply().length - 1)]);
            voucher.setId(id.getAndIncrement());
            vouchers.add(voucher);
        }
    }

    private  void takeSomeNotes(String note,List<TravelVoucher> vouchers) {

        try {
            int parseInt = Integer.parseInt(note);
            double parseDouble = Double.parseDouble(note);
            vouchers.forEach(voucher -> {
                final boolean find;
                if (parseInt == voucher.getId()) {
                    find = true;
                } else if (parseDouble == voucher.getCost()) {
                    find = true;
                } else if (note.equals(voucher.getDestination())) {
                    find = true;
                } else if (parseInt == voucher.getTripLength()) {
                    find = true;
                } else if (note.equals(voucher.getTransport())) {
                    find = true;
                } else if (note.equals(voucher.getSupply())) {
                    find = true;
                } else find = false;
                if (find) {
                    printVoucher(voucher);
                }

            });

        } catch (NumberFormatException e) {
            vouchers.forEach(voucher -> {
                final boolean find;
                if (note.equals(voucher.getDestination())) {
                    find = true;
                } else if (note.equals(voucher.getTransport())) {
                    find = true;
                } else if (note.equals(voucher.getSupply())) {
                    find = true;
                } else find = false;
                if (find) {
                    printVoucher(voucher);
                }
            });

        }
    }
}
