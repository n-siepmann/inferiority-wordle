/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nick.Siepmann
 */
@Service
public class ScoreService {

    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public String saveScore(Score score) {
        Score savedScore = this.scoreRepository.save(score);
        return savedScore.toString();
    }

    public List<Score> getScores() {
        List<Score> scores = this.scoreRepository.findAll();
        return scores;
    }

    public List<Score> getScoreByWord(String word) {
        List<Score> scores = this.scoreRepository.findByWord(word);
        return scores;
    }

    public long[] getAverageScoreByWord(String word) {
        long[] averageScores = {0, 0};
        List<Score> scores = this.scoreRepository.findByWord(word);
        for (Score score : scores) {
            averageScores[0] += score.getGuesses();
            averageScores[1] += score.getTime();
        }

        if (!scores.isEmpty()) {
            averageScores[0] /= scores.size();
            averageScores[1] /= scores.size();
        }
        return averageScores;
    }

    public void removeAllScores() {
        this.scoreRepository.deleteAll();
    }
    
    public List<List<Object>> getScoresList() {
         List<List<Object>> scoresList = new ArrayList<>();
         this.scoreRepository.findAll().stream().forEach(s -> scoresList.add(List.of(s.getTime(),s.getGuesses())));
        return scoresList;
    }
}
 