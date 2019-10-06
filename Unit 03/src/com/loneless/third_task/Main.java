package com.loneless.third_task;

import com.loneless.third_task.counter.Counter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            Scanner scanner=new Scanner(System.in);
            Counter counter=new Counter();
            while (true) {
                try {
                    System.out.println("Enter\n1 to set start value\n2 to set range\n3 to decrease value\n4 to increase value\n" +
                            "5 to see counter status\n-1 to exit");
                    switch (scanner.nextInt()) {
                        case -1:
                            return;
                        case 1:
                            System.out.println("Enter start value");
                            if (counter.setValue(scanner.nextInt()))
                                System.out.println("value was set");
                            else System.out.println("value out of range");
                            break;
                        case 2:
                            System.out.println("Enter range of counter. First go less number");
                            if(counter.setRange(new int[]{scanner.nextInt(),scanner.nextInt()})){
                                System.out.println("Range was set successful");
                            }
                            else System.out.println("invalid range");
                            break;
                        case 3:
                            if(counter.decreaseValue())
                                System.out.println("decrease successful");
                            else{
                                System.out.println("out of range");
                            }
                            break;
                        case 4:
                            if(counter.increaseValue())
                                System.out.println("decrease successful");
                            else{
                                System.out.println("out of range");
                            }
                            break;
                        case 5:
                            System.out.println(counter.toString());
                    }
                }
                catch (java.util.InputMismatchException e ){
                    System.out.println("Enter a valid data");
                    scanner.skip(".*\n");
                }
            }
        }
    }
}
