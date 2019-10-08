package com.loneless.second_task;

import java.util.Arrays;

public class TrainBookLogic {

    public TrainBookLogic() {

    }


    public  Train[]  sorting(int choice,Train[] trains){
        int startIndex = 0;
        int endIndex = trains.length - 1;
        if(choice==1) {
            doSortByNumber(startIndex, endIndex, trains);
        }
        else if(choice==2){
            doSortByDestination(startIndex, endIndex,trains);
        }
        return trains;
    }

    public Train findTrainPos(String name,TrainBook trainBook){
        return trainBook.getTrains(Arrays.binarySearch(trainBook.getTrains(),new Train(name)));
    }


    private void doSortByNumber(int start, int end, Train[] trains) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (trains[i].getNumber().compareTo(trains[cur].getNumber())>=0 )) {
                i++;
            }
            while (j > cur && (trains[cur].getNumber().compareTo(trains[j].getNumber())>=0 )) {
                j--;
            }
            if (i < j) {
                Train temp = trains[i];
                trains[i] = trains[j];
                trains[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortByNumber(start, cur,trains);
        doSortByNumber(cur+1, end,trains);
    }
    private void doSortByDestination(int start, int end, Train[] trains) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            boolean less = false;
            do {

                if ((trains[i].getDestination().compareTo(trains[cur].getDestination()) == 0)) {
                    if( trains[cur].getDepartureDate().compareTo(trains[j].getDepartureDate()) >= 0) {
                        less=true;
                    }
                }
                i++;
            }
            while (i < cur && less) ;
            less = false;
            do {
                if ((trains[i].getDestination().compareTo(trains[cur].getDestination()) == 0)) {
                    if( (trains[cur].getDepartureDate().compareTo(trains[j].getDepartureDate()) >= 0))
                    less=true;
                }
                j--;
            }
            while (j > cur && less);
            if (i < j) {
                Train temp = trains[i];
                trains[i] = trains[j];
                trains[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortByNumber(start, cur,trains);
        doSortByNumber(cur+1, end,trains);
    }

}
