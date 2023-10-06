package org.example.player.moves;

import org.example.interfaces.MoveStrategy;

public class Paper implements MoveStrategy {
    @Override
    public String handMove() {
        return "Paper";
    }
}
