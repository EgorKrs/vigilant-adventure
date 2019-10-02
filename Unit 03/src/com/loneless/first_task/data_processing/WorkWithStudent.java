package com.loneless.first_task.data_processing;

import com.loneless.first_task.data.Student;
import com.loneless.first_task.data_collection.StudentBase;

public class WorkWithStudent {
    private StudentBase studentBase;
    public WorkWithStudent(){
        this.studentBase=new StudentBase();
    }
    public WorkWithStudent(StudentBase studentBase){
        this.studentBase=studentBase;
    }

    public void addSomeStudent(){
        int progress[]=new int[5];
        Student defaultStudent0=new Student();
        defaultStudent0.setSurname("Exelent");
        defaultStudent0.setInitials("S.U.");
        defaultStudent0.setGroup("90ND90");
        for(int i=0;i<5;i++){
            progress[i]=9;
        }
        defaultStudent0.setProgress(progress);
        studentBase.add(defaultStudent0);
        Student defaultStudent1=new Student();
        defaultStudent1.setSurname("NotExelent");
        defaultStudent1.setInitials("S.U.");
        defaultStudent1.setGroup("90ND90");
        progress=new int[5];
        for(int i=0;i<5;i++){
            progress[i]=7;
        }
        defaultStudent1.setProgress(progress);
        studentBase.add(defaultStudent1);
    }

    public Student[] getExcellentPupil(){
        int emptySpace=0;
        boolean exelent;
        Student base[]=new Student[studentBase.getSize()];
        for(int i=0;i<base.length;i++){
            exelent=true;
            if(studentBase.getStudents()[i]!=null) {
                for (int j = 0; j < studentBase.getStudents().length; j++)
                    if (studentBase.getStudents()[i].getProgress()[j] < 9) {
                        exelent = false;
                        break;
                    }
                if (exelent) {
                    base[emptySpace] = studentBase.getStudents()[i];
                    emptySpace++;
                }
            }
        }
        return base;
    }
}
