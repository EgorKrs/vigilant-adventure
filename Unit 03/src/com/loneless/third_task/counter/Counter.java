package com.loneless.third_task.counter;

import java.util.Arrays;
import java.util.Random;

public class Counter {
    private int range[];
    private int value;
    {
        range=new int[2];
        range[1]=99;
    }
    public Counter(){
        Random random=new Random();
        value=random.nextInt(range[1]);
    }
    public Counter(int range[],int value){

    }
    public boolean increaseValue(){
        if(value+1<range[1]) {
            value++;
            return true;
        }
        else return false;
    }
    public boolean decreaseValue(){
        if(value-1>range[0]){
            value--;
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "range=" + Arrays.toString(range) +
                ", value=" + value +
                '}';
    }

    public Counter getCounter(){
        return this;
    }

    public int[] getRange() {
        return range;
    }

    public boolean setRange(int[] range) {
        if(range[0]<range[1]) {
            this.range = range;
            if(range[0]>value||range[1]<value)
                value=range[0];
            return true;
        }
        else return false;
    }

    public int getValue() {
        return value;
    }

    public boolean setValue(int value) {
        if(value>=range[0]&&value<=range[1]) {
            this.value = value;
            return true;
        }
        else return false;
    }
}
