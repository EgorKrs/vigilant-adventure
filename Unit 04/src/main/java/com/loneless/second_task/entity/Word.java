package com.loneless.second_task.entity;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word.toString(), word1.word.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word=" + word +
                '}';
    }
}
