/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nick.Siepmann
 */
@Component
public class WordList {

    private String[] words;
    private Random random;
    private final Logger logger;

    public WordList() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.random = new Random();
        this.logger = Logger.getLogger(Game.class.getName());
        
        try {
            this.words = objectMapper.readValue(this.getClass().getClassLoader().getResource("static/wordleList.json"), String[].class);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }

    public String[] getWords() {
        return words;
    }

    public String getRandomWord() {

        String randWord = this.words[this.random.nextInt(this.words.length)].toUpperCase();
        
        return randWord;
    }

    public boolean wordFound(String word){
        return Arrays.asList(this.words).contains(word);
    }
    
}
