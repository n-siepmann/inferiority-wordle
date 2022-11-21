/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nick.Siepmann
 */
public class GameTest {

    private Game underTest;
    private WordList wordList;

    @BeforeEach
    @Autowired
    void setup() {
        this.wordList = new WordList();
        this.underTest = new Game(wordList);
    }

    @Test
    void canSetTargetWord() {
        String word = "testy";
        this.underTest.setTarget(word);
        assertThat(this.underTest.getTarget().equals(word.toUpperCase())).isTrue();
    }

    @Test
    void canSetNewTargetWord() {
        String word = "testy";
        this.underTest.setTarget(word);
        this.underTest.setNewTarget();
        assertThat(this.underTest.getTarget().equals(word.toUpperCase())).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
        "testy, testy, valid",
        "testy, ttttt, Please enter a valid word.",
        "testy, termite, Please enter a five-letter word."})
    void canValidateGuess(String target, String guess, String returned) {
        this.underTest.setTarget(target);
        assertEquals(this.underTest.validGuess(guess), returned);
    }

    @ParameterizedTest
    @CsvSource({
        "testy, tiars, bendy, Please enter a word which matches the found letters.",
        "testy, tiars, third, valid"})
    void canValidateSecondGuess(String target, String guess, String secondguess, String returned) {
        this.underTest.setTarget(target);
        this.underTest.checkGuess(guess);
        assertEquals(this.underTest.validGuess(secondguess), returned);
    }

    @ParameterizedTest
    @CsvSource({
        "testy, testy, true, TESTY",
        "testy, tinge, false, T***e",
        "testy, birch, false, *****"})
    void guessCheckIsCorrectAndSolvedIsCorrect(String target, String guess, boolean correct, String solved) {
        this.underTest.setTarget(target);
        assertEquals(this.underTest.checkGuess(guess), correct);
        assertEquals(this.underTest.getSolved(), solved);
    }
}
