package org.example.opponents;

import org.example.interfaces.MoveStrategy;

import java.util.Random;

public class Computer implements MoveStrategy, Opponent {
    private final String name;
    private int score;

    public Computer() {
        this.name = "Computer";
    }

    public String getName() {
        return name;
    }


    @Override
    public int getOpponentScore() {
        return score;
    }

    @Override
    public void incrementOpponentScore() {
        score++;
    }

    @Override
    public String handMove() {
        Random random = new Random();
        int computerChoice = random.nextInt(3) + 1;

        switch (computerChoice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
        }
        return null;
    }
}
