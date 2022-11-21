/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nick.Siepmann
 */
public class GuessTest {
    
    private Guess underTest;
    private WordList wordList;
    
    @BeforeEach
    @Autowired
    void loadWordlist() {
        this.wordList = new WordList();
    }
    
    @Test
    void guessShouldBeLowerCaseWithNoSpace() {
        //given
        String input = " Testy ";
        String output = "testy";
        //when
        this.underTest = new Guess(input, this.wordList);

        //then
        assertThat(this.underTest.getText().equals(output));
    }
}
