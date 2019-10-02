package com.loneless.first_task.data;

public class Student {
    private String surname;
    private String initials;
    private String group;
    private int[] progress;

    public Student(String surname, String initials, String group, int []progress){
        setGroup(group);
        setInitials(initials);
        setProgress(progress);
        setSurname(surname);
    }
    public Student(){

    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
