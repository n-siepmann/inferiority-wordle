/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nick.Siepmann
 */
@Controller
public class WordleController {

    private final ScoreController scoreController;
    private final WordList wordList;
    private Game game;

    @Autowired
    public WordleController(ScoreController scoreController, WordList wordList) {
        this.scoreController = scoreController;
        this.wordList = wordList;
        this.game = new Game(this.wordList);
    }

    @GetMapping("/")
    public String gamePage(Model model) {
        if (!isNull(this.game) && !this.game.isSolved()) {
            model.addAttribute("guesses", this.game.getGuessLog());
            return "index";
        }
        this.game = new Game(this.wordList);
        model.addAttribute("guesses", this.game.getGuessLog());
        return "redirect:/";
    }

    @GetMapping("/cheat")
    public String cheat(@RequestParam(value = "name", defaultValue = "cheat") String name, Model model) {
        this.game = new Game(this.wordList);
        this.game.setTarget(name);        
        System.out.println(this.game.getTarget());
        model.addAttribute("guesses", this.game.getGuessLog());
        return "index";
    }

    @GetMapping("/newgame")
    public String newGame(Model model) {
        this.game = new Game(this.wordList);
        model.addAttribute("guesses", this.game.getGuessLog());
        return "redirect:/";
    }

    @PostMapping("/guess")
    public String tryGuess(@ModelAttribute Guess guess, Model model) {
        model.addAttribute("guess", guess);

//        System.out.println("Guess entered: " + guess.getText());
        String err = this.game.validGuess(guess.getText());
        model.addAttribute("error", err);

        if (err.equals("valid")) {
            this.game.checkGuess(guess.getText());

            if (this.game.isSolved()) {
                Score userScore = new Score(this.game.getGuessCount(), this.game.getTime(), this.game.getTarget());
                model.addAttribute("word", this.game.getTarget());
                model.addAttribute("scores", this.scoreController.getScoresList());
                model.addAttribute("userScore", List.of(List.of(userScore.getTime(), userScore.getGuesses())));
                model.addAttribute("userGuesses", userScore.getGuesses());
                model.addAttribute("userTime", userScore.getTime());
                this.scoreController.saveScore(userScore); //because scores list is not ordered chronologically, need to add last score to the chart manually before saving to db
                return "success";
            }

            if (this.game.getGuessCount() > 5) {
                model.addAttribute("word", this.game.getTarget());
                long[] average = scoreController.getAverageScoreByWord(this.game.getTarget());
                model.addAttribute("avguesses", average[0]);
                model.addAttribute("avtime", average[1]);
                return "failure";
            }
        }

        model.addAttribute("guesses", this.game.getGuessLog());
        return "index";
    }

}
