/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import java.time.Instant;

/**
 *
 * @author Nick.Siepmann
 */
class Timer {

    private long start;
    private long stop;
    private long total;

    public Timer() {
        this.start = Instant.now().getEpochSecond();
        this.stop = 0;
        this.total = 0;
    }

    public void stopTimer() {
        this.stop = Instant.now().getEpochSecond();
        this.total = stop - start;
    }

    public long getTotal() {
        if (this.stop == 0) {
            stopTimer();
        }
        this.total = stop - start;
        return this.total;
    }
}
