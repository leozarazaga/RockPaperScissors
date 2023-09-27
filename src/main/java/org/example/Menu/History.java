package org.example.Menu;

import org.example.Computer;
import org.example.Player;

import java.util.List;

public class History {
    public static void displayGameHistory(Player player, Computer computer) {
        System.out.println("\nGame History:");
        System.out.println("Player vs Computer");

        List<RoundResult> playerHistory = player.getPlayerHistory();
        List<RoundResult> computerHistory = computer.getComputerHistory();

        for (int i = 0; i < playerHistory.size(); i++) {
            RoundResult playerRound = playerHistory.get(i);
            RoundResult computerRound = computerHistory.get(i);

            System.out.println("Round " + (i + 1) + ":");
            System.out.println(player.getName() + ": " + playerRound.getPlayerChoice() + " | Computer: " + playerRound.getComputerChoice() + " | Result: " + playerRound.getResult());
            //  System.out.println("  Computer: " + computerRound.getPlayerChoice() + " | Player: " + playerRound.getComputerChoice() + " | Result: " + computerRound.getResult());
        }
    }

}
