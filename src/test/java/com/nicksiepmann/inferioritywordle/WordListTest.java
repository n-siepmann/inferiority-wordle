/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Nick.Siepmann
 */
public class WordListTest {

    private WordList underTest;

    @BeforeEach
    void setup() {
        this.underTest = new WordList();
    }

    @Test
    void wordListIsLoaded() {
        assertThat(this.underTest).isNotNull();
    }

    @Test
    void wordListGivesValidWord() {
        String exampleWord = this.underTest.getRandomWord();

        assertThat(exampleWord.length() == 5 && exampleWord.equals(exampleWord.toUpperCase())).isTrue();
    }

    @Test
    void wordListGivesNonIdenticalWords() {
        Set<String> words = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            String word = this.underTest.getRandomWord();
            words.add(word);
        }
        assertThat(words.size() == 10).isTrue();

    }

    @ParameterizedTest
    @CsvSource({"testy, true", "ttttt, false"})
    void wordListCanValidateWords(String input, boolean valid) {
        assertThat(this.underTest.wordFound(input) == valid).isTrue();
    }

}
