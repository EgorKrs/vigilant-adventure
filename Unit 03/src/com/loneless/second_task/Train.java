package com.loneless.second_task;

import java.util.Date;

public class Train {
    private String destination;
    private String number;
    private Date departureDate;

    Train(){}

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
}
