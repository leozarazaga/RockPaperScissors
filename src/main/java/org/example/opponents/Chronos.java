package org.example.opponents;

import org.example.interfaces.MoveStrategy;

public class Chronos implements MoveStrategy, Opponent {
    private final String name;
    private int score;

    public Chronos(){
        this.name = "Chronos";
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
        int currentTime = (int) (System.currentTimeMillis() % 3);
        if (currentTime == 0) {
            return "Rock";
        } else if (currentTime == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
}
