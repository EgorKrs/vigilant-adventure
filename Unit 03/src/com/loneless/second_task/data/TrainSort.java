package com.loneless.second_task.data;

import com.loneless.second_task.data.Train;

public class TrainSort extends Train {
    public TrainSort(Train train){
        setDepartureDate(train.departureDate);
        setDestination(train.destination);
        setNumber(train.number);
    }
    public int compareTo(Train other) {
        if(this.getDestination()==null)
            return 1;
        else if(other.getDestination()==null)
            return -1;
        else if(this.getDestination().compareTo(other.getDestination()) > 0)
            return 1;
        else if (this.getDestination().equals(other.getDestination())) {
            if (this.getDepartureDate().compareTo(other.getDepartureDate())>0)
                return 1;
            else
                return -1;
        }
        return -1 ;
    }

}
