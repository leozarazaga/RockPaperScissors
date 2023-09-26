package org.example.GameLogic;

import org.example.Moves.MoveStrategy;

public class GameLogic {

    public void PlayGame(MoveStrategy playerStrategy, MoveStrategy computerStrategy) {
        String playerSelectsMove = playerStrategy.moveAttack();
        String computerSelectsMove = computerStrategy.moveAttack();

        if (playerSelectsMove.equals(computerSelectsMove)) {
            System.out.println("It is a tie!");
        } else if ((playerSelectsMove.equals("Rock") && computerSelectsMove.equals("Scissors")) ||
                (playerSelectsMove.equals("Paper") && computerSelectsMove.equals("Rock")) ||
                (playerSelectsMove.equals("Scissors") && computerSelectsMove.equals("Paper"))) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}
