package com.loneless.first_task;

import com.loneless.first_task.data.Student;
import com.loneless.first_task.data_collection.StudentBase;
import com.loneless.first_task.data_processing.WorkWithStudent;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StudentBase studentBase=new StudentBase();
        WorkWithStudent workWithStudent=new WorkWithStudent(studentBase);
        workWithStudent.addSomeStudent();
        while (true){
            System.out.println("Введите 1 для добавления студента\n2 для просмотра всех студентов\n" +
                    "3 для просмотра отличников\n-1 для выхода");
            switch (scanner.nextInt()){
                case -1:
                    return;
                case 1:
                    Student student=new Student();
                    scanner.nextLine();
                    System.out.println("Enter student surname");
                    student.setSurname(scanner.nextLine());
                    System.out.println("Enter student initials");
                    student.setInitials(scanner.nextLine());
                    System.out.println("Enter student group");
                    student.setGroup(scanner.nextLine());
                    System.out.println("Enter quantity of student subject");
                    int size=scanner.nextInt();
                    System.out.println("Enter student marks");
                    int progress[]=new int[size];
                    for(int i=0;i<size;i++){
                        progress[i]=scanner.nextInt();
                    }
                    student.setProgress(progress);
                    System.out.println("Adding student is: "+studentBase.add(student));
                    break;
                case 2:
                    for (int i=0;i<studentBase.getStudents().length;i++) {
                        if(studentBase.getStudents()[i]!=null) {
                            System.out.println("Surname is: " + studentBase.getStudents()[i].getSurname());
                            System.out.println("Group is: " + studentBase.getStudents()[i].getGroup()+"\n");
                        }
                    }
                    break;
                case 3:
                    Student exelentStudent[]=workWithStudent.getExcellentPupil();
                    for (int i=0;i<exelentStudent.length;i++) {
                        if(exelentStudent[i]!=null) {
                            System.out.println("Surname is: " + exelentStudent[i].getSurname());
                            System.out.println("Group is: " + exelentStudent[i].getGroup() + "\n");
                        }
                    }
                    break;
            }
        }

    }
}
