package com.loneless.homevork.task02;

import logic.GeneratorMagic;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int size;
        System.out.println("Введите размерность квадрата от 3 для корректных магических квадратов");
        Scanner scanner=new Scanner(System.in);
        size=scanner.nextInt();
        GeneratorMagic magic=new GeneratorMagic();
        if(size%2!=0){
            magic.generateOddMagicSquare(size);
            printMas(magic.getMatrix());

        }
        else {
            magic.generateEvenMagicSquare(size);
            printMas(magic.getMatrix());
        }
    }
    public static void printMas(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("The Magic Square for n= "+matrix.length);
        System.out.println("Sum of each row or column= "+matrix.length*(matrix.length*matrix.length+1)/2);
    }
}
