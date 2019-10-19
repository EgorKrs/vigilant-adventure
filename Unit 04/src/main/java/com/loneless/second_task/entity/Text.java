package com.loneless.second_task.entity;


import java.util.ArrayList;
import java.util.List;

public class Text  {
    private List<Sentence> sentences=new ArrayList<>();
    private String header;

    public List<Sentence> getWords() {
        return sentences;
    }

    public void setWords(List<Sentence> words) {
        this.sentences = words;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public StringBuilder receiveIdea() {
        StringBuilder idea=new StringBuilder();
        for (Sentence sentence :
                sentences) {
            idea.append(sentence.receiveIdea().append(" "));
        }
        return idea;
    }

    public void supplementation(Sentence sentence){
        sentences.add(sentence);
    }
    public void supplementation(Word word){
        Sentence sentence=new Sentence();
        sentence.supplementation(word);
        sentences.add(sentence);
    }
    public void supplementation(String sentence){

    }

}
