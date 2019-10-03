package com.loneless.second_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        DataHandler handler=new DataHandler();
        handler.basicBook();
        while (true){
            try {
                System.out.println("Enter 1 to add train\n2 to see all trains\n" +
                        "3 to sort trains\n4 to find train\n-1 для выхода");
                switch (scanner.nextInt()) {
                    case -1:
                        return;
                    case 1:
                        boolean errFlag=true;
                        Train train = new Train();
                        scanner.nextLine();
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
                                System.out.println("Enter valid data");
                            }
                        }
                        System.out.println(handler.add(train));
                        break;
                    case 2:
                        for (int i = 0; i < handler.getTrainBook().getTrains().length; i++) {
                            if (handler.getTrainBook().getTrains()[i].getNumber() != null) {
                                System.out.println("Number is: " + handler.getTrainBook().getTrains(i).getNumber());
                                System.out.println("Destination is: " + handler.getTrainBook().getTrains(i).getDestination());
                                System.out.println("Departure date is: " + handler.getTrainBook().getTrains(i).getDepartureDate() + "\n");
                            }
                        }
                        break;
                    case 3:
                        handler.sorting();
                        break;
                    case 4:
                        String name;
                        System.out.println("Enter name of train");
                        handler.sorting();
                        scanner.nextLine();
                        name = scanner.nextLine();
                        Train trainThatWasLooking = handler.findTrainPos(name);
                        if (trainThatWasLooking != null) {
                            System.out.println("Number is: " + trainThatWasLooking.getNumber());
                            System.out.println("Destination is: " + trainThatWasLooking.getDestination());
                            System.out.println("Departure date is: " + trainThatWasLooking.getDepartureDate() + "\n");
                        } else System.out.println("NO such train\n");
                    default:
                        System.out.println("Please enter valid number of menu");
                }
            }
            catch (java.util.InputMismatchException e ){
                System.out.println("Enter a valid data");
                scanner.skip(".*\n");
            }
        }

    }
}
