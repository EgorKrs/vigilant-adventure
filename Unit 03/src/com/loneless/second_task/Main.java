package com.loneless.second_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        TrainBook trainBook=new TrainBook();
        TrainBookLogic handler=new TrainBookLogic();
        basicBook(trainBook);
        while (true){
            try {
                System.out.println("Enter \n1 to add train\n2 to see all trains\n" +
                        "3 to sort trains\n4 to find train\n-1 для выхода");
                switch (scanner.nextInt()) {

                    case -1:
                        return;
                    case 1:
                        boolean errFlag=true;
                        Train train = new Train();
                        scanner.skip(".*\n");
                        System.out.println("Enter name of train");
                        train.setNumber(scanner.nextLine());
                        System.out.println("Enter destination");
                        train.setDestination(scanner.nextLine());
                        while (errFlag) {
                            try {
                                System.out.println("Enter departure date(yyyy-MM-dd)");
                                train.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine()));
                                errFlag = false;
                            } catch (ParseException e) {
                                System.out.println("Enter valid beans");
                            }
                        }
                        System.out.println("Train was add successfully: "+ trainBook.add(train));
                        break;
                    case 2:
                        for (int i = 0; i < trainBook.getTrains().length; i++) {
                            if (!trainBook.getTrains()[i].getNumber().equals("")) {
                                System.out.println(trainBook.getTrains()[i].toString()+"\n");

                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter\n1 to sort by number\n2 sort by departure time");
                        int choice=scanner.nextInt();
                        handler.sorting(choice,trainBook.getTrains());
                            for (int i = 0; i <trainBook.getTrains().length; i++) {
                                if (!trainBook.getTrains()[i].getNumber().equals("")) {
                                    System.out.println(trainBook.getTrains()[i].toString()+"\n");
                                }
                            }

                        break;
                    case 4:
                        String name;
                        System.out.println("Enter name of train");
                        handler.sorting(1,trainBook.getTrains());
                        scanner.skip(".*\n");
                        name = scanner.nextLine();
                        Train trainThatWasLooking = handler.findTrainPos(name,trainBook);
                        if (trainThatWasLooking != null) {
                            System.out.println(trainThatWasLooking.toString()+"\n");
                        } else System.out.println("NO such train\n");
                    default:
                        System.out.println("Please enter valid number of menu");
                }
            }
            catch (java.util.InputMismatchException e ){
                System.out.println("Enter a valid beans");
                scanner.skip(".*\n");
            }
        }

    }
    private static void basicBook(TrainBook trainBook){
        try {
            Train train=new Train("mos","123qwe",new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-22"));
            trainBook.add(train);
            train=new Train("mos","321",new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-11"));
            trainBook.add(train);
            train=new Train("mos","111",new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-12"));
            trainBook.add(train);
            for (int i=3;i<trainBook.getTrains().length;i++){
                train=new Train();
                trainBook.add(train);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
