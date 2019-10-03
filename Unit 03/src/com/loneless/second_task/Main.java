package com.loneless.second_task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        DataHandler handler=new DataHandler();
        handler.basicBook();
        while (true){
            System.out.println("Enter 1 to add train\n2 to see all trains\n" +
                    "3 to sort trains\n4 to find train\n-1 для выхода");
            switch (scanner.nextInt()){
                case -1:
                    return;
                case 1:

                    break;
                case 2:
                    for (int i=0;i<handler.getTrainBook().getTrains().length;i++) {
                        if(handler.getTrainBook().getTrains()[i].getNumber()!=null) {
                            System.out.println("Number is: " + handler.getTrainBook().getTrains(i).getNumber());
                            System.out.println("Destination is: " + handler.getTrainBook().getTrains(i).getDestination());
                            System.out.println("Departure date is: " + handler.getTrainBook().getTrains(i).getDepartureDate()+"\n");
                        }
                    }
                    break;
                case 3:
                    handler.sorting();
                    break;
                case 4:
                    System.out.println("Number is: " +  handler.findTrainPos("321").getNumber());
                    System.out.println("Destination is: " +  handler.findTrainPos("321").getDestination());
                    System.out.println("Departure date is: " + handler.findTrainPos("321").getDepartureDate()+"\n");
            }
        }

    }
}
