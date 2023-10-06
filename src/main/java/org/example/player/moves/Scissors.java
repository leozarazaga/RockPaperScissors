package org.example.player.moves;

import org.example.interfaces.MoveStrategy;

public class Scissors implements MoveStrategy {
    @Override
    public String handMove() {
        return "Scissors";
    }
}
