/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Nick.Siepmann
 */
public class GuessTest {
    
    private Guess underTest;

    @Test
    void guessShouldBeLowerCaseWithNoSpace() {
        //given
        String input = " Testy ";
        String output = "testy";
        //when
        this.underTest = new Guess(input);

        //then
        assertThat(this.underTest.getText().equals(output));
    }
}
