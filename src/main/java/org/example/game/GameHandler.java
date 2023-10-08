package org.example.game;

import org.example.interfaces.MoveStrategy;
import org.example.opponents.Opponent;
import org.example.player.Player;

import java.util.Scanner;

public class GameHandler {
    private final Player player;
    private final Opponent opponent;

    public GameHandler(Player player, Opponent opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void startTheGame(int roundsSelectedByPlayer) {
        Scanner scanner = new Scanner(System.in);

        int roundCount = 0;
        while (roundCount < roundsSelectedByPlayer) {
            roundCount++;

            System.out.println("\nRound " + roundCount + " / " + roundsSelectedByPlayer);

            MoveStrategy playerChoice = player.getPlayerChoice(scanner);
            String opponentChoice = opponent.handMove();

            System.out.println("\nYou selected: " + playerChoice.handMove());
            System.out.println(opponent.getName() + " selected: " + opponentChoice);
            scanner.nextLine();

            String roundResult = gameLogic(playerChoice.handMove(), opponentChoice);
            System.out.println(roundResult);


            if (roundResult.equals("Player wins!")) {
                player.incrementPlayerScore();
            } else if (roundResult.equals("Opponent wins!")) {
                opponent.incrementOpponentScore();
            }

            String opponentName = opponent.getName();
            player.addToPlayerHistory(playerChoice.handMove(), opponentChoice, roundResult, opponentName);
        }
    }

    public String gameLogic(String playerChoice, String opponentChoice) {
        if (playerChoice.equals(opponentChoice)) {
            return "It is a tie!";
        } else if ((playerChoice.equals("Rock") && opponentChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && opponentChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && opponentChoice.equals("Paper"))) {
            return "Player wins!";
        } else {
            return "Opponent wins!";
        }
    }
}

