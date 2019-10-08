package com.loneless;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Task40 task40=new Task40();
       Task32 task32=new Task32();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter yours number for task 40");
        System.out.println("Numbers that you looking for "+task40.execute(scanner.nextInt()));
        System.out.println("Enter yours 3 number for task 32");
        System.out.println("Is positive sum possible: "+task32.execute(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
    }
}
