package com.loneless.fourth_task.travel_vouchers;

import java.util.Objects;

public abstract class  TravelVoucher {
    protected int id;
    protected int cost;
    protected String destination;
    protected int tripLength;
    protected String transport;
    protected String supply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTripLength() {
        return tripLength;
    }

    public void setTripLength(int tripLength) {
        this.tripLength = tripLength;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
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
