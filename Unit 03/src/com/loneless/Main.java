package com.loneless;

import com.loneless.firstTask.Student;
import com.loneless.firstTask.StudentBase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choise;
        StudentBase studentBase=new StudentBase();
        while (true){
            System.out.println("Введите 1 для добавления студента\n2 для просмотра всех студентов\n" +
                    "3 для просмотра отличников\n-1 для выхода");
            switch (scanner.nextInt()){
                case -1:
                    return;
                case 1:
                    Student student=new Student();
                    studentBase
                    break;
            }
        }

    }
}
