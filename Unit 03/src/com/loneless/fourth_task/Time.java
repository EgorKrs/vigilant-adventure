package com.loneless.fourth_task;

import java.util.Objects;

public class Time {
    private int hour;
    private int min;
    private int sec;
    public Time(){}

    public Time(int hour,int min,int sec){
       setHour(hour);
       setMin(min);
       setSec(sec);
    }
    public Time(int ...time){
        setHour(time[0]);
        setMin(time[1]);
        setSec(time[2]);
    }

    public int getHour() {
        return hour;
    }

    public boolean setHour(int hour) {
        if(hour>=0&&hour<23) {
            this.hour = hour;
            return true;
        }
        else {
            this.hour=0;
            return false;
        }
    }

    public int getMin() {
        return min;
    }

    public boolean setMin(int min) {
        if(min>=0&&min<=60) {
            this.min = min;
            return true;
        }
        else {
            this.min = 0;
            return false;
        }
    }

    public int getSec() {
        return sec;
    }

    public boolean setSec(int sec) {
        if(sec>=0&&sec<=60) {
            this.sec = sec;
            return true;
        }
        else {
            this.sec = 0;
            return false;
        }
    }

    public int[] getIntTime(){
        return new int[]{this.hour,this.min,this.sec};
    }
    public String getStringTime(){
        return this.hour+":"+this.min+":"+this.sec;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", min=" + min +
                ", sec=" + sec +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour &&
                min == time.min &&
                sec == time.sec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, min, sec);
    }
}
