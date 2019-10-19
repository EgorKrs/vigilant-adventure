package com.loneless.fourth_task.entity;

import com.loneless.DataGenerator;

public class Shopping extends TravelVoucher{
    public enum PossibleDestination{
        first(DataGenerator.getInstance().getFaker().elderScrolls().region(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        second(DataGenerator.getInstance().getFaker().elderScrolls().region(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        third(DataGenerator.getInstance().getFaker().elderScrolls().region(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        fourth(DataGenerator.getInstance().getFaker().elderScrolls().region(),DataGenerator.getInstance().getRandom().nextDouble()*1000);

        private String place;
        private double price;
        PossibleDestination(String place,double price) {
            this.place = place;
            this.price=price;
        }

        public double getPrice() {
            return price;
        }

        public String getPlace() {
            return place;
        }

    }

    public enum PossibleTripLength{
        first(DataGenerator.getInstance().getRandom().nextInt(360),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        second(DataGenerator.getInstance().getRandom().nextInt(360),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        third(DataGenerator.getInstance().getRandom().nextInt(360),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        fourth(DataGenerator.getInstance().getRandom().nextInt(360),DataGenerator.getInstance().getRandom().nextDouble()*1000);

        double price;
        private int length;

        PossibleTripLength(int length,double price){
            this.length=length;
            this.price=price;
        }

        public int getLength() {
            return length;
        }
    }

    public enum PossibleTransport{
        first(DataGenerator.getInstance().getFaker().team().creature(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        second(DataGenerator.getInstance().getFaker().team().creature(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        third(DataGenerator.getInstance().getFaker().team().creature(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        fourth(DataGenerator.getInstance().getFaker().team().creature(),DataGenerator.getInstance().getRandom().nextDouble()*1000);

        private String transport;
        private double price;

        PossibleTransport(String transport,double price){
            this.transport = transport;
            this.price=price;
        }

        public String getTransport() {
            return transport;
        }
    }

    public enum PossibleSupply{
        first(DataGenerator.getInstance().getFaker().beer().name(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        second(DataGenerator.getInstance().getFaker().food().dish(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        third(DataGenerator.getInstance().getFaker().food().fruit(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        fourth(DataGenerator.getInstance().getFaker().food().sushi(),DataGenerator.getInstance().getRandom().nextDouble()*1000),
        fifth(DataGenerator.getInstance().getFaker().food().vegetable(),DataGenerator.getInstance().getRandom().nextDouble()*1000);

        private double price;
        private String supply;

        PossibleSupply(String transport,double price){
            this.supply = transport;
            this.price=price;
        }

        public double getPrice() {
            return price;
        }

        public String getSupply() {
            return supply;
        }
    }

    @Override
    public int[] receivePossibleLength() {
        return new int[]{PossibleTripLength.first.length,PossibleTripLength.second.getLength(),
                PossibleTripLength.third.getLength(),PossibleTripLength.fourth.getLength()};
    }

    @Override
    public String[] receivePossibleDestination() {
        return new String[]{PossibleDestination.first.getPlace(),PossibleDestination.second.getPlace(),
                PossibleDestination.third.getPlace(),PossibleDestination.fourth.getPlace()};
    }

    @Override
    public String[] receivePossibleTransport() {
        return new String[]{PossibleTransport.first.getTransport(),PossibleTransport.second.getTransport(),
                PossibleTransport.third.getTransport(),PossibleTransport.fourth.getTransport()};
    }

    @Override
    public Object[] receivePossibleSupply() {
        return new String[]{PossibleSupply.first.getSupply(),PossibleSupply.second.getSupply(),
                PossibleSupply.third.getSupply(),PossibleSupply.fourth.getSupply(),PossibleSupply.fifth.getSupply()};
    }

    @Override
    public boolean setDestination(String destination) {
        boolean find = false;
        if (PossibleDestination.first.place.equals(destination)) {
            addToCost(PossibleDestination.first.price);
            find = true;
        } else if (PossibleDestination.second.place.equals(destination)) {
            addToCost(PossibleDestination.second.price);
            find = true;
        } else if (PossibleDestination.third.place.equals(destination)) {
            addToCost(PossibleDestination.third.price);
            find = true;
        } else if (PossibleDestination.fourth.place.equals(destination)) {
            addToCost(PossibleDestination.third.price);
            find = true;
        }
        if (find) {
            super.setDestination(destination);
            return true;
        } else return false;
    }

    @Override
    public boolean setTripLength(int tripLength)  {
        boolean find=false;
        if(PossibleTripLength.first.getLength()==tripLength){
            addToCost(PossibleTripLength.first.price);
            find=true;
        }
        else if(PossibleTripLength.second.getLength()==tripLength){
            addToCost(PossibleTripLength.second.price);
            find=true;
        }
        else if(PossibleTripLength.third.getLength()==tripLength){
            addToCost(PossibleTripLength.third.price);
            find=true;
        }
        else if(PossibleTripLength.fourth.getLength()==tripLength) {
            addToCost(PossibleTripLength.third.price);
            find=true;
        }
        if(find){
            super.setTripLength(tripLength);
            return true;
        }
        else return false;
    }

    @Override
    public boolean setTransport(String transport) {
        boolean find = false;
        if (PossibleTransport.first.transport.equals(transport)) {
            addToCost(PossibleTransport.first.price);
            find = true;
        } else if (PossibleTransport.second.transport.equals(transport)) {
            addToCost(PossibleTransport.second.price);
            find = true;
        } else if (PossibleTransport.third.transport.equals(transport)) {
            addToCost(PossibleTransport.third.price);
            find = true;
        } else if (PossibleTransport.fourth.transport.equals(transport)) {
            addToCost(PossibleTransport.third.price);
            find = true;
        }
        if (find) {
            super.setTransport(transport);
            return true;
        } else return false;
    }

    @Override
    public boolean setSupply(String supply) {
        boolean find = false;
        if (PossibleSupply.first.supply.equals(supply)) {
            addToCost(PossibleSupply.first.price);
            find = true;
        } else if (PossibleSupply.second.supply.equals(supply)) {
            addToCost(PossibleSupply.second.price);
            find = true;
        } else if (PossibleSupply.third.supply.equals(supply)) {
            addToCost(PossibleSupply.third.price);
            find = true;
        } else if (PossibleSupply.fourth.supply.equals(supply)) {
            addToCost(PossibleSupply.third.price);
            find = true;
        }
        if (find) {
            super.setSupply(supply);
            return true;
        } else return false;
    }
}
