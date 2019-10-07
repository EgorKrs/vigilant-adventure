package com.loneless.fourth_task.data;

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
}
