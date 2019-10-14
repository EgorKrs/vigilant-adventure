package com.loneless.second_task.idea_units;

import com.loneless.second_task.Idea;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Idea {
    private List<Word> words=new ArrayList<>();
    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
    @Override
    public StringBuilder receiveIdea() {
        StringBuilder idea=new StringBuilder();
        for (Word word :
                words) {
            idea.append(word.getSymbols());
        }
        return idea;
    }


}
