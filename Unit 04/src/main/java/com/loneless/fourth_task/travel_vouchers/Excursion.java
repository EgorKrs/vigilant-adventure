package com.loneless.fourth_task.travel_vouchers;

import com.loneless.fourth_task.DataGenerator;

public class Excursion extends TravelVoucher {
    public enum PossibleDestination{
        first(DataGenerator.getInstance().getFaker().elderScrolls().region()),
        second(DataGenerator.getInstance().getFaker().elderScrolls().region()),
        third(DataGenerator.getInstance().getFaker().elderScrolls().region()),
        fourth(DataGenerator.getInstance().getFaker().elderScrolls().region());

        private String place;

        PossibleDestination(String place) {
            this.place = place;
        }

        public String getPlace() {
            return place;
        }
    }

    public enum PossibleTripLength{
        first(DataGenerator.getInstance().getRandom().nextInt(360)),
        second(DataGenerator.getInstance().getRandom().nextInt(360)),
        third(DataGenerator.getInstance().getRandom().nextInt(360)),
        fourth(DataGenerator.getInstance().getRandom().nextInt(360));

        private int length;

        PossibleTripLength(int length){
            this.length=length;
        }

        public int getLength() {
            return length;
        }
    }

    public enum PossibleTransport{
        first(DataGenerator.getInstance().getFaker().team().creature()),
        second(DataGenerator.getInstance().getFaker().team().creature()),
        third(DataGenerator.getInstance().getFaker().team().creature()),
        fourth(DataGenerator.getInstance().getFaker().team().creature());

        private String transport;

        PossibleTransport(String transport){
            this.transport = transport;
        }

        public String getTransport() {
            return transport;
        }
    }

    public enum PossibleSupply{
        first(DataGenerator.getInstance().getFaker().beer().name()),
        second(DataGenerator.getInstance().getFaker().food().dish()),
        third(DataGenerator.getInstance().getFaker().food().fruit()),
        fourth(DataGenerator.getInstance().getFaker().food().sushi()),
        fifth(DataGenerator.getInstance().getFaker().food().vegetable());


        private String supply;

        PossibleSupply(String transport){
            this.supply = transport;
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
        if(PossibleDestination.first.getPlace().equals(destination)||
                PossibleDestination.second.getPlace().equals(destination)||
                PossibleDestination.third.getPlace().equals(destination)||
                PossibleDestination.fourth.getPlace().equals(destination)){
            super.setDestination(destination);
            return true;
        }
        else return false;
    }

    @Override
    public boolean setTripLength(int tripLength)  {
        if(PossibleTripLength.first.getLength()==tripLength||PossibleTripLength.second.getLength()==tripLength||
                PossibleTripLength.third.getLength()==tripLength||PossibleTripLength.fourth.getLength()==tripLength){
            super.setTripLength(tripLength);
            return true;
        }
        else return false;
    }

    @Override
    public boolean setTransport(String transport) {
        if(PossibleTransport.first.getTransport().equals(transport)||
                PossibleTransport.second.getTransport().equals(transport)||
                PossibleTransport.third.getTransport().equals(transport)||
                PossibleTransport.fourth.getTransport().equals(transport)){
            super.setTransport(transport);
            return true;
        }
        else return false;
    }

    @Override
    public boolean setSupply(String supply) {
        if (PossibleSupply.first.getSupply().equals(supply) ||
                PossibleSupply.second.getSupply().equals(supply) ||
                PossibleSupply.third.getSupply().equals(supply) ||
                PossibleSupply.fourth.getSupply().equals(supply) ||
                PossibleSupply.fifth.getSupply().equals(supply)) {
            super.setSupply(supply);
            return true;
        } else return false;
    }
}
