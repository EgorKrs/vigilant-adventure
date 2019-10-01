package com.loneless.firstTask;

public class WorkWithStudent {
    private StudentBase studentBase;
    public StudentBase getExcellentPupil(){
        int emptySpace=0;
        boolean exelent=true;
        Student base[]=new Student[studentBase.getSize()];
        for(int i=0;i<base.length;i++){
            exelent=true;
            for(int j =0;j<studentBase.getStudent().length;j++)
                if(studentBase.getStudent()[i].getProgress()[i]<=9) {
                    exelent = false;
                    break;
                }
            if(exelent){
                base[emptySpace]=studentBase.getStudent()[i];
                emptySpace++;
            }
        }
        return studentBase;
    }
}
