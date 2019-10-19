package com.loneless.second_task;

import com.loneless.second_task.entity.Sentence;
import com.loneless.second_task.entity.Text;
import com.loneless.second_task.entity.Word;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Text text=new Text();
        Scanner reader=new Scanner(System.in);
        while (true){
            System.out.println("Введите\n1 для дополнения текста\n2 для вывода текста\n3 для вывода заголовка текста" +
                    "\n-1 для выхода");
            switch (reader.nextLine()) {
                case "-1":
                    return;
                case "1":
                    System.out.println("Введите строку/слово для добавления");
                    Sentence sentence = new Sentence();
                    String[] words = reader.nextLine().split(" ");
                    for (String word :
                            words) {
                        sentence.supplementation(new Word(word));
                    }
                    text.supplementation(sentence);
                    break;
                case "2":
                    System.out.println(text.receiveIdea());
                    break;
                case "3":
                    System.out.println("Заголовок: "+ text.getHeader());
                    break;
                    default:
                        System.out.println("Не верный ввод");
            }
        }
    }
}
