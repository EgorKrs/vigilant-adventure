package com.loneless.first_task;

public class GroupLogic {

    public GroupLogic(){

    }

    public Student[] getExcellentPupil(Group group){
        int emptySpace=0;
        boolean exelent;
        Student students[]=new Student[group.getSize()];
        for(int i=0;i<students.length;i++){
            exelent=true;
            if(group.getStudents()[i]!=null) {
                for (int j = 0; j < group.getStudents().length; j++)
                    if (group.getStudents()[i].getProgress()[j] < 9) {
                        exelent = false;
                        break;
                    }
                if (exelent) {
                    students[emptySpace] = group.getStudents()[i];
                    emptySpace++;
                }
            }
        }
        return students;
    }
}
