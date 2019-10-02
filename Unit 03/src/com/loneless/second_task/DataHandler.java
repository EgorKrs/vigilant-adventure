package com.loneless.second_task;

import java.util.Arrays;

public class DataHandler {
    TrainBook trainBook;

    public DataHandler() {
        trainBook=new TrainBook();
    }

    public DataHandler(TrainBook trainBook) {
        this.trainBook = trainBook;
    }

    public void sorting(){
        Arrays.sort(trainBook.getTrains());
    }

    public Train findTrainPos(String name){
        return trainBook.getTrains(Arrays.binarySearch(trainBook.getTrains(),name));
    }

    public void basicBook(){
        Train train=new Train("123qwe","mos",22.09.2019)
    }

}
