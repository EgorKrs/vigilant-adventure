package com.loneless.first_task.data_collection;

import com.loneless.first_task.data.Student;

public class StudentBase {
    private Student students[];
    private int size;
    private int lastIndex=0;
    public StudentBase() {
    setSize(5);
    students=new Student[5];
    }
    public void setSize(int size) {
        if(size>0)
        this.size = size;
        else this.size=5;
    }

    public int getSize() {
        return size;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
    public String add(Student student){
        String strToRet;
        if(lastIndex<size){
            students[lastIndex]=student;
            lastIndex++;
            strToRet="success";
        }
        else strToRet="fullStack";
        return strToRet;
    }
}
