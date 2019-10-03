package com.loneless.second_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        return trainBook.getTrains(Arrays.binarySearch(trainBook.getTrains(),new Train(name)));
    }

    public String add(Train train){
        return trainBook.add(train);
    }

    public void basicBook(){
        try {
            Train train=new Train("mos","123qwe",new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-22"));
            trainBook.add(train);
            train=new Train("mos","321",new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-12"));
            trainBook.add(train);
            train=new Train("mos","111",new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-12"));
            trainBook.add(train);
            for (int i=3;i<trainBook.getTrains().length;i++){
                train=new Train();
                trainBook.add(train);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public TrainBook getTrainBook() {
        return trainBook;
    }

    public void setTrainBook(TrainBook trainBook) {
        this.trainBook = trainBook;
    }
}
