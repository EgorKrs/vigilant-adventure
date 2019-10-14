package com.loneless.fourth_task.travel_vouchers;

import com.loneless.fourth_task.DataGenerator;

public class Recreation extends TravelVoucher{
    public String[] resivePossibleDestinations(){ // значения генерятся одинаково,
        // но тут типо разные значения для каждого класса, возможно с разной логикой
        String[] possibleVariants=new String[3];
        possibleVariants[0]= DataGenerator.getInstance().getFaker().elderScrolls().region();
        possibleVariants[1]= DataGenerator.getInstance().getFaker().elderScrolls().region();
        possibleVariants[2]= DataGenerator.getInstance().getFaker().elderScrolls().region();
        return possibleVariants;
    }
    public int[] resivePossibleTripLength(){
        int[] possibleVariants=new int[3];
        possibleVariants[0]=DataGenerator.getInstance().getRandom().nextInt(360);
        possibleVariants[1]=DataGenerator.getInstance().getRandom().nextInt(360);
        possibleVariants[2]=DataGenerator.getInstance().getRandom().nextInt(360);
        return possibleVariants;
    }
    public String[] resivePossibleTransport(){
        String[] possibleVariants=new String[3];
        possibleVariants[0]=DataGenerator.getInstance().getFaker().team().creature();
        possibleVariants[1]=DataGenerator.getInstance().getFaker().team().creature();
        possibleVariants[2]=DataGenerator.getInstance().getFaker().team().creature();
        return possibleVariants;
    }
    public String[] resivePossibleSupply(){
        String[] possibleVariants=new String[5];
        possibleVariants[0]=DataGenerator.getInstance().getFaker().beer().name();
        possibleVariants[1]=DataGenerator.getInstance().getFaker().food().dish();
        possibleVariants[2]=DataGenerator.getInstance().getFaker().food().fruit();
        possibleVariants[3]=DataGenerator.getInstance().getFaker().food().sushi();
        possibleVariants[4]=DataGenerator.getInstance().getFaker().food().vegetable();
        return possibleVariants;
    }
}
