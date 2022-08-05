/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;


import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Nick.Siepmann
 */
public class Game {

    private char[] target;
    private char[] solved;
    private ArrayList<String> guessLog;
    private Timer timer;
    private WordList wordList;

    public Game(WordList wordList) {
        this.wordList = wordList;
        this.target = wordList.getRandomWord().toCharArray();
        this.solved = "*****".toCharArray();
        this.guessLog = new ArrayList<>();
        this.timer = new Timer();

    }

//    //for demonstration purposes 
//    public Game(String target, WordList wordlist) {
//
//        this.target = target.toUpperCase().toCharArray();
//        this.solved = "*****".toCharArray();
//        this.guessLog = new ArrayList<>();
//        this.timer = new Timer();
//    }

    public void setTarget(String word) {
        this.target = word.toUpperCase().toCharArray();
    }

    public String validGuess(String guess) {
        if (guess.length() != 5) {
            return "Please enter a five-letter word.";
        }
        if (!wordList.wordFound(guess)) {
            return "Please enter a valid word.";
        }
        char[] guessArr = guess.toUpperCase().toCharArray();
        for (int i = 0; i < 5; i++) {
            if (String.valueOf(solved[i]).matches("[A-Z]") && guessArr[i] != solved[i]) {
                return "Please enter a word which matches the found letters.";
            }
        }
        return "valid";
    }

    public boolean checkGuess(String guess) {
        char[] guessArr = guess.toUpperCase().toCharArray();
//        System.out.println("target " + this.getTarget());
        for (int i = 0; i < 5; i++) {
            if (guessArr[i] == target[i]) {
                solved[i] = target[i];
            } else if (this.getUnsolved().contains((String.valueOf(guessArr[i])))) {
                solved[i] = Character.toLowerCase(guessArr[i]);
            } else {
                solved[i] = '*';
            }
        }
        guessLog.add(getSolved());
        return isSolved();
    }

    public String getTarget() {
        return String.valueOf(target);
    }

    public String getSolved() {
        return String.valueOf(solved);
    }

    public ArrayList<String> getGuessLog() {
        return guessLog;
    }

    public int getGuessCount() {
        return guessLog.size();
    }

    private String getUnsolved() {
        String unsolved = "";

        for (int i = 0; i < 5; i++) {
            if (solved[i] != target[i]) {
                unsolved = unsolved + target[i];
            }
        }
        return unsolved;
    }

    @Override
    public String toString() {
        return "GuessWord{" + "target=" + String.valueOf(target) + ", solved=" + String.valueOf(solved) + '}';
    }

    public boolean isSolved() {
        if (Arrays.toString(target).equals(Arrays.toString(solved))) {
            this.timer.stopTimer();
            return true;
        }
        return false;
    }

    public long getTime() {
        return this.timer.getTotal();
    }
}
