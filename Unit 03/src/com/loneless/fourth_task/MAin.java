package com.loneless.fourth_task;

import com.loneless.fourth_task.data.Time;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MAin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Time time = new Time(cal.get(Calendar.HOUR),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
        do {

                try {
                    System.out.println("Enter\n1 to set new time\n2 to set hour\n3 to set min\n4 to set sec\n" +
                            "5 to see time\n-1 to exit");
                    switch (scanner.nextInt()) {
                        case -1:
                            return;
                        case 1:
                            System.out.println("Enter start value");
                            time=new Time(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
                            break;
                        case 2:
                            System.out.println("Enter hour");
                            if(time.setHour(scanner.nextInt()))
                                System.out.println("Hour was set successful");
                            else System.out.println("invalid hour. Hour was set as 0");
                            break;
                        case 3:
                            System.out.println("Enter min");
                            if(time.setMin(scanner.nextInt()))
                                System.out.println("Min was set successful");
                            else System.out.println("invalid min. Min was set as 0");
                            break;
                        case 4:
                            System.out.println("Enter sec");
                            if(time.setSec(scanner.nextInt()))
                                System.out.println("Sec was set successful");
                            else System.out.println("invalid sec. sec was set as 0");
                            break;
                        case 5:
                            System.out.println(time.getStringTime()+"\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Enter a valid data");
                    scanner.skip(".*\n");
                }
        } while (true);
    }
}
