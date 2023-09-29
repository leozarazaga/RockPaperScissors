package org.example;

import org.example.GameLogic.GameLogic;
import org.example.Moves.MoveStrategy;

import java.util.Scanner;

public class GameHandler {
    private Player player;
    private Computer computer;
    public GameHandler(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }
    public void playGame(int roundsSelectedByPlayer) {
        Scanner scanner = new Scanner(System.in);

        int roundCount = 0;
        while (roundCount < roundsSelectedByPlayer) {
            roundCount++;

            System.out.println("\nRound " + roundCount + " / " + roundsSelectedByPlayer);

            MoveStrategy playerChoice = player.getPlayerChoice(scanner);
            MoveStrategy computerChoice = computer.generateComputerMove();

            System.out.println("\nYou selected: " + playerChoice.moveAttack());
            System.out.println("Computer selected: " + computerChoice.moveAttack());
            scanner.nextLine();

            GameLogic game = new GameLogic();
            String roundResult = game.PlayGame(playerChoice, computerChoice);
            System.out.println(roundResult);

            if (roundResult.equals("Player wins!")) {
                player.incrementPlayerScore();
            } else if (roundResult.equals("Computer wins!")) {
                computer.incrementComputerScore();
            }

            player.addToPlayerHistory(playerChoice.moveAttack(), computerChoice.moveAttack(), roundResult);
        }
    }
}
