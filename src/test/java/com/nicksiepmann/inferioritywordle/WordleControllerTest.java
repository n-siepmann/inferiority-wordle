/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 *
 * @author Nick.Siepmann
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordleControllerTest {

    WordleController underTest;

//    @LocalServerPort
//    private int port;
//    @Autowired
//    private TestRestTemplate restTemplate;
    @Mock
    ScoreService scoreService;
    @Mock
    WordList wordList;

    @Autowired
    MockMvc model;

//    public WordleControllerTest() {
//    }
    @BeforeEach
    public void setUp() {
        given(wordList.getRandomWord()).willReturn("testy");
        this.underTest = new WordleController(scoreService, wordList);
    }
//
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of gamePage method, of class WordleController.
     */
    @Test
    public void testGamePage() throws Exception {
        //given
        //when
        //then
        this.model.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test of cheat method, of class WordleController.
     */
//    @Test
//    public void testCheat() {
//        //given
//        //when
//        //then
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of newGame method, of class WordleController.
//     */
//    @Test
//    public void testNewGame() {
//        //given
//        //when
//        //then
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tryGuess method, of class WordleController.
//     */
//    @Test
//    public void testTryGuess() {
//        //given
//        //when
//        //then
//        fail("The test case is a prototype.");
//    }
}
