/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Nick.Siepmann
 */
@Entity(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private final long guesses;
    private final long time;
    private final String word;

    public Score(long guesses, long time, String word) {
        this.guesses = guesses;
        this.time = time;
        this.word = word;

    }

    public long getId(){
        return this.id;
    }
    
    public long getGuesses() {
        return guesses;
    }

    public long getTime() {
        return time;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "Score{" + "id=" + id + ", guesses=" + guesses + ", time=" + time + ", word=" + word + '}';
    }

}
