package com.loneless.first_task;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String surname;
    private String initials;
    private String group;
    private int[] progress;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(surname, student.surname) &&
                Objects.equals(initials, student.initials) &&
                Objects.equals(group, student.group) &&
                Arrays.equals(progress, student.progress);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(surname, initials, group);
        result = 31 * result + Arrays.hashCode(progress);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", initials='" + initials + '\'' +
                ", group='" + group + '\'' +
                ", progress=" + Arrays.toString(progress) +
                '}';
    }
}
