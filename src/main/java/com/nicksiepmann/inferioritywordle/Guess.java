/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

/**
 *
 * @author Nick.Siepmann
 */

public class Guess  {
    private String text;

    public Guess(String text) {
        this.text = text.strip().toLowerCase();
    }

    public String getText() {
        return text;
    }
    
}
