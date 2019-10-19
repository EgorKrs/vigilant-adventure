package com.loneless.first_task;

import com.loneless.DataGenerator;
import com.loneless.first_task.entity.City;
import com.loneless.first_task.entity.District;
import com.loneless.first_task.entity.Government;
import com.loneless.first_task.entity.Region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Government government=createCountry();
        BufferedReader reader=new BufferedReader( new InputStreamReader(System.in));
        while (true) {
            System.out.println("Введите\n1 для просмотра столицы\n2 для вывода кол-ва областей\n3 для вывода площади" +
                    "\n4 для вывода областных центров\n5 для просмотра всех единиц \n -1 для выхода");
            switch (reader.readLine()){
                case "-1":
                    return;
                case "1":
                    System.out.println("Столица:\n"+government.getCapital().toString());
                    break;
                case "2":
                    System.out.println("Кол-во областей: "+government.receiveQuantityOfIncomingTerritories());
                    break;
                case "3":
                    System.out.println("Площадь: "+ government.countSize());
                    break;
                case "4":
                    System.out.println("Областные центры: \n"+government.receiveSmallerCenter());
                    break;
                case "5":
                    seeAllUnit(government);
                    break;
                    default:
                        System.out.println("Нет такого выбора");
            }
        }
    }
    private static void createSomeCity(District district){
        City city;
        for (int i=0;i<5;i++){
            city=new City(DataGenerator.getInstance().getRandom().nextDouble()*1000,
                    DataGenerator.getInstance().getFaker().address().streetName(),
                    DataGenerator.getInstance().getFaker().address().cityName());
            district.addCity(city);
        }
    }

    private static void createSomeDistrict(Region region){
        District district;
        for (int i=0;i<5;i++){
            district=new District();
            createSomeCity(district);
            district.setDistrictCenter(district.getCity(DataGenerator.getInstance().getRandom().nextInt(
                    district.receiveQuantityOfIncomingTerritories())));
            district.setNameOfDistrict(DataGenerator.getInstance().getFaker().address().state());
            region.addDistrict(district);
        }
    }

    private static void createSomeRegions(Government government){
        Region region;
        for(int i=0;i<5;i++){
            region=new Region();
            createSomeDistrict(region);
            region.setCentralDistrict(region.getDistrict(DataGenerator.getInstance().getRandom().nextInt(
                    region.receiveQuantityOfIncomingTerritories())));
            region.setName(DataGenerator.getInstance().getFaker().address().stateAbbr());
            government.addRegion(region);
        }
    }

    private static Government createCountry(){
        Government government=new Government();
        government.setNameOfGovernment(DataGenerator.getInstance().getFaker().address().country());
        createSomeRegions(government);
        government.setCapital(government.getRegion(DataGenerator.getInstance().getRandom().nextInt(5))
                .getDistrict(DataGenerator.getInstance().getRandom().nextInt(5)).
                        getCity(DataGenerator.getInstance().getRandom().nextInt(5)));
        return government;
    }

    private static void seeAllUnit(Government government){
        for (Region region :
                government.getRegions()) {
            System.out.println(region.toString());
        }
    }
}
