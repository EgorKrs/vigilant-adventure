package com.loneless.second_task;

import java.util.Arrays;

public class TrainBook {
    Train trains[];

    public TrainBook() {
        trains=new Train[5];
    }

    public Train[] getTrains() {
        return trains;
    }

    public Train getTrains(int index) {
        return trains[index];
    }

    public void setTrains(Train[] trains) {
        this.trains = trains;
    }

}
