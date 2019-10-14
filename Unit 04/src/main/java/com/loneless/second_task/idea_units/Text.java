package com.loneless.second_task.idea_units;

import com.loneless.second_task.Idea;

import java.util.ArrayList;
import java.util.List;

public class Text implements Idea {
    private List<Word> words=new ArrayList<>();
    private String header;

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public StringBuilder receiveIdea() {
        StringBuilder idea=new StringBuilder();
        for (Word word :
                words) {
            idea.append(word.receiveIdea());
        }
        return idea;
    }
}
