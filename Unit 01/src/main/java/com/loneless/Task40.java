package com.loneless;

/*Получить все числа, не превышающие заданного числа N, которые делятся без остатка на все свои
цифры.*/
public class Task40 {
    private int numeral[];
    public StringBuilder execute(int number){
        StringBuilder numbersThatWeNeed= new StringBuilder();
        int n=number;
        int size=0;
        boolean isDivided=true;
        while (n>0){
            if(n-(n/10)*10!=0){
                size++;
            }
            n=n/10;
        }
        numeral=new int[size];
        n=number;
        for (int i=0;n>0;){
            if(n-(n/10)*10!=0) {
                numeral[i] =n-(n/10)*10;
                i++;
            }
            n=n/10;
        }
        for(int num=2;num<number;num++) {
            isDivided=true;
            for (int i = 0; i < size; i++) {
                if (num % numeral[i] != 0) {
                    isDivided = false;
                    break;
                }
            }
            if (isDivided) {
                numbersThatWeNeed.append(num).append(" ");
            }
        }
        return numbersThatWeNeed;
    }
}
