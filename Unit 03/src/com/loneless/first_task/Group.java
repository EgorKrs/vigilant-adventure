package com.loneless.first_task;

public class Group {
    private Student students[];
    private int size;
    private int lastIndex=0;

    public Group() {
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

    public boolean add(Student student){
        if(lastIndex<size){
            students[lastIndex]=student;
            lastIndex++;
            return true;
        }
        return false;
    }
}
