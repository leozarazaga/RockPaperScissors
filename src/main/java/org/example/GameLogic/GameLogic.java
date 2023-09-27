package org.example.GameLogic;

import org.example.Moves.MoveStrategy;

public class GameLogic {

    public String PlayGame(MoveStrategy playerStrategy, MoveStrategy computerStrategy) {
        String playerSelectsMove = playerStrategy.moveAttack();
        String computerSelectsMove = computerStrategy.moveAttack();

        if (playerSelectsMove.equals(computerSelectsMove)) {
            //System.out.println("It is a tie!");
            return "It is a tie!";
        } else if ((playerSelectsMove.equals("Rock") && computerSelectsMove.equals("Scissors")) ||
                (playerSelectsMove.equals("Paper") && computerSelectsMove.equals("Rock")) ||
                (playerSelectsMove.equals("Scissors") && computerSelectsMove.equals("Paper"))) {
            //System.out.println("Player wins!");
            return "Player wins!";
        } else {
            //System.out.println("Computer wins!");
            return "Computer wins!";
        }
    }
}
