package org.example.GameLogic;

import org.example.Moves.MoveStrategy;

public class GameLogic {

    public String PlayGame(MoveStrategy playerStrategy, MoveStrategy computerStrategy) {
        String playerSelectsMove = playerStrategy.moveAttack();
        String computerSelectsMove = computerStrategy.moveAttack();

        if (playerSelectsMove.equals(computerSelectsMove)) {
            return "It is a tie!";
        } else if ((playerSelectsMove.equals("Rock") && computerSelectsMove.equals("Scissors")) ||
                (playerSelectsMove.equals("Paper") && computerSelectsMove.equals("Rock")) ||
                (playerSelectsMove.equals("Scissors") && computerSelectsMove.equals("Paper"))) {return "Player wins!";
        } else {
            return "Computer wins!";
        }
    }
}
