package com.loneless.second_task.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Text{" +
                "sentences=" + sentences +
                ", header='" + header + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(sentences, text.sentences) &&
                Objects.equals(header, text.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences, header);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
