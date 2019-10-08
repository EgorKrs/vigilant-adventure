package com.loneless.second_task;



public class TrainBook {
    Train trains[];

    public TrainBook() {
        trains=new Train[5];
    }

    public Train[] getTrains() {
        return trains;
    }

    public boolean add(Train train){
        boolean isEmpty=false;
        for (int i=0;i<trains.length;i++) {
            if (trains[i]==null)
               isEmpty=true;
            else if(train.getNumber()!=null&&trains[i].getNumber().equals(""))
                isEmpty=true;
            if(isEmpty){
                trains[i] = train;
               return true;
            }
        }

        return false;
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
