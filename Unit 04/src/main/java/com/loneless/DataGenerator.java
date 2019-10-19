package com.loneless;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {
    private static final DataGenerator instance =new DataGenerator();

    private static final Faker faker =new Faker();// прикольная "генерация" объектов - это для базовых значений

    private static final Random random=new Random();

    private DataGenerator(){}

    public static DataGenerator getInstance() {
        return instance;
    }

    public Faker getFaker(){
        return faker;
    }

    public Random getRandom(){
        return random;
    }

}
