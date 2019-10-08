package com.loneless.second_task;
import java.util.Date;
import java.util.Objects;

public class Train {
    private String destination;
    private String number;
    private Date departureDate;

    public Train(){
        destination="";
        number="";
        departureDate= new Date();
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(destination, train.destination) &&
                Objects.equals(number, train.number) &&
                Objects.equals(departureDate, train.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, number, departureDate);
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", number='" + number + '\'' +
                ", departureDate=" + departureDate +
                '}';
    }
}
