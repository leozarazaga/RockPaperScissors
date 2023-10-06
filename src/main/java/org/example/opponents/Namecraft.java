package org.example.opponents;

import org.example.interfaces.MoveStrategy;

public class Namecraft implements MoveStrategy, Opponent {
    private final String name;
    private int score;
    private final String playerName;

    public Namecraft(String playerName) {
        this.name = "Namecraft";
        this.playerName = playerName;
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
        int nameLength = playerName.length();
        if (nameLength % 3 == 0) {
            return "Rock";
        } else if (nameLength % 3 == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
}
