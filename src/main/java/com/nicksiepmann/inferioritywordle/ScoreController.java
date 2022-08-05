/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 *
 * @author Nick.Siepmann
 */
@ShellComponent
public class ScoreController {

    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @ShellMethod("Saves current score to Cloud Datastore: save-score <score>")
    public String saveScore(Score score) {
        Score savedScore = this.scoreRepository.save(score);
        return savedScore.toString();
    }

    @ShellMethod("Loads all scores")
    public List<Score> getScores() {
        List<Score> scores = this.scoreRepository.findAll();
        return scores;
    }

    @ShellMethod("Loads all scores for a given word")
    public List<Score> getScoreByWord(String word) {
        List<Score> scores = this.scoreRepository.findByWord(word);
        return scores;
    }

    @ShellMethod("Get average score for a given word")
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

    @ShellMethod("Removes all scores")
    public void removeAllScores() {
        this.scoreRepository.deleteAll();
    }
    
    @ShellMethod("Gets scores as a list of list of objects for GCharts")
    public List<List<Object>> getScoresList() {
         List<List<Object>> scoresList = new ArrayList<>();
         List<Score> scores = this.scoreRepository.findAll();
         for (int i = 0; i < scores.size(); i++){
             scoresList.add(List.of(scores.get(i).getTime(),scores.get(i).getGuesses()));
         }
        return scoresList;
    }
}
