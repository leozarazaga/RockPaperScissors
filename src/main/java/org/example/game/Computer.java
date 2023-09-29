package org.example.game;

import org.example.util.RoundResult;
import org.example.game.moves.MoveStrategy;
import org.example.game.moves.Paper;
import org.example.game.moves.Rock;
import org.example.game.moves.Scissors;

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

    public int getScore() {
        return score;
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
}
