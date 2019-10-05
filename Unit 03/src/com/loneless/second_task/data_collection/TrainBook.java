package com.loneless.second_task.data_collection;


import com.loneless.second_task.data.Train;
import com.loneless.second_task.data.TrainSort;

public class TrainBook {
    Train trains[];
    TrainSort sorts[];
    public TrainBook() {
        sorts=new TrainSort[5];
        trains=new Train[5];
    }

    public Train[] getTrains() {
        return trains;
    }

    public TrainSort[] getTrainsForSort() {
        for(int i=0;i<trains.length;i++)
        sorts[i]=new TrainSort(trains[i]);
        return sorts;
    }
    public TrainSort[] getTrainsSort() {
        return sorts;
    }
    public TrainSort getTrainsSort(int index) {
        return sorts[index];
    }

    public String add(Train train){
        String strToReturn=null;
        boolean isEmpty=false;
        for (int i=0;i<trains.length;i++) {
            if (trains[i]==null)
               isEmpty=true;
            else if(train.getNumber()!=null&&trains[i].getNumber()==null)
                isEmpty=true;
            if(isEmpty){
                trains[i] = train;
                strToReturn="train was add";
                break;
            }
        }
        if(strToReturn==null){
            strToReturn="error no free space";
        }
        return strToReturn;
    }


    public Train getTrains(int index) {
        if(index<trains.length&&index>=0)
        return trains[index];
        else return null;
    }

    public void setTrains(Train[] trains) {
        this.trains = trains;
    }

}
