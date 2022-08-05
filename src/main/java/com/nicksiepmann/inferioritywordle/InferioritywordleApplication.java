package com.nicksiepmann.inferioritywordle;

//import java.time.Instant;
//import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InferioritywordleApplication {

    public static void main(String[] args) {
        SpringApplication.run(InferioritywordleApplication.class, args);
//        offLineGuess();
    }

//    private static void offLineGuess() {
//        Game guess = new Game();
////        System.out.println(guess.toString());
//        Scanner scanner = new Scanner(System.in);
//        String userGuess;
//
//        System.out.println("Enter your guess:");
//        userGuess = scanner.nextLine();
//        long startTime = Instant.now().getEpochSecond();
//        int guessCount = 0;
//
//        for (int i = 0; i < 6; i++) {
//
//            while (!guess.validGuess(userGuess)) {
//                System.out.println("Invalid guess - choose a valid five-letter word matching all confirmed found letters");
//                userGuess = scanner.nextLine();
//            }
//
//            if (guess.checkGuess(userGuess)) {
//                guessCount = i + 1;
//                break;
//            }
//
//            System.out.println(guess.getSolved());
//            System.out.println("Enter your guess:");
//            userGuess = scanner.nextLine();
//        }
//
//        if (guess.isSolved()) {
//            long[] yourScore = {guessCount, Instant.now().getEpochSecond() - startTime};
//            System.out.println("Well done! You got " + guess.getTarget() + " in " + (yourScore[0]) + "! It took you " + yourScore[1] + " seconds.");
//
//        } else {
//            System.out.println("You didn't get it - the word was " + guess.getTarget());
//        }
//    }
//
}
