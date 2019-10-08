package com.loneless.first_task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Group group =new Group();
        GroupLogic groupLogic =new GroupLogic();
        addSomeStudent(group);
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
                    System.out.println("Adding is: "+ group.add(student));
                    break;
                case 2:
                    for (int i = 0; i< group.getStudents().length; i++) {
                        if(group.getStudents()[i]!=null) {
                            System.out.println("Surname is: " + group.getStudents()[i].getSurname());
                            System.out.println("Group is: " + group.getStudents()[i].getGroup()+"\n");
                        }
                    }
                    break;
                case 3:
                    Student exelentStudent[]= groupLogic.getExcellentPupil(group);
                    for (Student anExelentStudent : exelentStudent) {
                        if (anExelentStudent != null) {
                            System.out.println("Surname is: " + anExelentStudent.getSurname());
                            System.out.println("Group is: " + anExelentStudent.getGroup() + "\n");
                        }
                    }
                    break;
            }
        }

    }
    private static void addSomeStudent(Group group){
        int progress[]=new int[5];
        Student defaultStudent0=new Student();
        defaultStudent0.setSurname("Exelent");
        defaultStudent0.setInitials("S.U.");
        defaultStudent0.setGroup("90ND90");
        for(int i=0;i<5;i++){
            progress[i]=9;
        }
        defaultStudent0.setProgress(progress);
        group.add(defaultStudent0);
        Student defaultStudent1=new Student();
        defaultStudent1.setSurname("NotExelent");
        defaultStudent1.setInitials("S.U.");
        defaultStudent1.setGroup("90ND90");
        progress=new int[5];
        for(int i=0;i<5;i++){
            progress[i]=7;
        }
        defaultStudent1.setProgress(progress);
        group.add(defaultStudent1);
    }
}
