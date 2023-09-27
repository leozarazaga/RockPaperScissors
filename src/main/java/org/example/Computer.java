package org.example;

import org.example.Menu.RoundResult;
import org.example.Moves.MoveStrategy;
import org.example.Moves.Paper;
import org.example.Moves.Rock;
import org.example.Moves.Scissors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private int score;
    private List<RoundResult> computerHistory;

    public Computer() {
        this.score = 0;
        this.computerHistory = new ArrayList<>();
    }

    //Getters
    public int getScore() {
        return score;
    }

    public List<RoundResult> getComputerHistory() {
        return computerHistory;
    }

    public void incrementComputerScore() {
        score++;
    }

    public MoveStrategy generateComputerMove() {
        Random random = new Random();
        int computerChoice = random.nextInt(3) + 1;

        switch (computerChoice) {
            case 1:
                return new Rock();
            case 2:
                return new Paper();
            case 3:
                return new Scissors();
        }
        return null;
    }

    public void addToComputerHistory(String playerChoice, String computerChoice, String gameRoundResult) {
        computerHistory.add(new RoundResult(playerChoice, computerChoice, gameRoundResult));
    }


}
