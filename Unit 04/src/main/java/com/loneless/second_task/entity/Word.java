package com.loneless.second_task.entity;



public class Word {
    private StringBuilder word;

    public StringBuilder getWord() {
        return word;
    }

    public void setWord(StringBuilder word) {
        this.word = word;
    }

    public StringBuilder receiveIdea() {
        StringBuilder idea=new StringBuilder();
        return idea.append(getWord());
    }
    public void supplementation(StringBuilder word){
        this.word.append(word);
    }

    public Word() {
        word=new StringBuilder();
    }

    public Word(String word) {
        this.word=new StringBuilder();
        this.word.append( word);
    }
}
