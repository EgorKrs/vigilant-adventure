package com.loneless.fourth_task.entity;

import java.util.Objects;

public abstract class  TravelVoucher {
    private int id;
    private double cost;
    private String destination;
    private int tripLength;
    private String transport;
    private String supply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addToCost(double prise){
        cost+=prise;
    }

    public String getDestination() {
        return destination;
    }

    public boolean setDestination(String destination) {
        this.destination = destination;
        return true;
    }

    public int getTripLength() {
        return tripLength;
    }

    public boolean setTripLength(int tripLength) {
        this.tripLength = tripLength;
        return true;
    }

    public String getTransport() {
        return transport;
    }

    public boolean setTransport(String transport) {
        this.transport = transport;
        return true;
    }

    public String getSupply() {
        return supply;
    }

    public boolean setSupply(String supply) {
        this.supply = supply;
        return true;
    }


    public Object[] receivePossibleDestination(){
        return null;
    }
    public int[] receivePossibleLength(){
        return null;
    }

    public Object[] receivePossibleTransport(){
        return null;
    }

    public Object[] receivePossibleSupply(){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelVoucher that = (TravelVoucher) o;
        return id == that.id &&
                cost == that.cost &&
                tripLength == that.tripLength &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(transport, that.transport) &&
                Objects.equals(supply, that.supply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, destination, tripLength, transport, supply);
    }

    @Override
    public String toString() {
        return "TravelVoucher{" +
                "id=" + id +
                ", cost=" + cost +
                ", destination='" + destination + '\'' +
                ", tripLength=" + tripLength +
                ", transport='" + transport + '\'' +
                ", supply='" + supply + '\'' +
                '}';
    }
}
