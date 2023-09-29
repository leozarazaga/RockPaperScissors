// NewGame.java
package org.example.menu;

import org.example.game.Computer;
import org.example.game.GameHandler;
import org.example.record.GameRecord;
import org.example.game.Player;

import java.util.Scanner;

public class NewGame {

    static Scanner scanner = new Scanner(System.in);
    public static void newGame() {
        System.out.println("\nYou vs Randomizer\n̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Rounds to play: ");
        int roundsSelectedByPlayer = scanner.nextInt();
        scanner.nextLine();

        Computer computer = new Computer();
        Player player = new Player(playerName);

        GameHandler gameHandler = new GameHandler(player, computer);
        gameHandler.playGame(roundsSelectedByPlayer);

        GameRecord gameRecord = new GameRecord(player.getName(), player.getPlayerHistory(), displayFinalResult(player, computer));

        History.addGameRecord(gameRecord);

        System.out.println("\nFinal Score: " + player.getName() + " " + player.getScore() + " - " + computer.getScore() + " Computer");
        goBackToMainMenu();
    }



    private static String displayFinalResult(Player player, Computer computer) {
        if (player.getScore() > computer.getScore()) {
            return "Player wins!";
        } else if (player.getScore() < computer.getScore()) {
            return "Computer wins!";
        } else {
            return "It's a tie!";
        }
    }


    public static void goBackToMainMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        MainMenu.mainMenu();
    }
}
