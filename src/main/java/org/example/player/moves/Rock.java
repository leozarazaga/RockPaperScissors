package org.example.player.moves;

import org.example.interfaces.MoveStrategy;

public class Rock implements MoveStrategy {
    @Override
    public String handMove() {
        return "Rock";
    }
}
