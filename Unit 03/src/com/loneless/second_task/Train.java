package com.loneless.second_task;

import java.util.Date;

public class Train implements Comparable<Train>{
    private String destination;
    private String number;
    private Date departureDate;

    Train(){    }

    public Train(String number) {
        this.number = number;
    }

    public Train(String destination, String number, Date departureDate) {
        this.destination = destination;
        this.number = number;
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int compareTo(Train other) {
        if(this.getNumber()==null)
            return 1;
        else if(other.getNumber()==null)
            return -1;
        else if(this.getNumber().compareTo(other.getNumber()) > 0)
            return 1;
        else if (this.getNumber().equals(other.getNumber()))
            return 0 ;
        return -1 ;
    }
}
