package com.loneless.second_task.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                '}';
    }
}
