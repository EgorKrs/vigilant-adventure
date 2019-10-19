package com.loneless.second_task.entity;


import java.util.ArrayList;
import java.util.List;

public class Sentence  {

    private List<Word> words=new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }

    public Word getWord(int index){
        return words.get(index);
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public StringBuilder receiveIdea() {
        StringBuilder idea=new StringBuilder();
        for (Word word :
                words) {
            idea.append(word.getWord().append(" "));
        }
        return idea;
    }
    public void supplementation(Word word){
        words.add(word);
    }
}
