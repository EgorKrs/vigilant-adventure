package com.loneless.second_task;



public class TrainBook {
    Train trains[];

    public TrainBook() {
        trains=new Train[5];
    }

    public Train[] getTrains() {
        return trains;
    }

    public String add(Train train){
        String strToReturn=null;
        for (int i=0;i<trains.length;i++) {
            if (trains[i] == null) {
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
        return trains[index];
    }

    public void setTrains(Train[] trains) {
        this.trains = trains;
    }

}
