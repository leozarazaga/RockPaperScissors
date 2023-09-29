// NewGame.java
package org.example.Menu;

import org.example.Computer;
import org.example.GameHandler;
import org.example.GameRecord;
import org.example.Player;

import java.util.Scanner;

public class NewGame {

    static Scanner scanner = new Scanner(System.in);
    public static Player player;
    private static Computer computer;

    public static void newGame() {
        System.out.println("\nNew Game\n̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Rounds to play: ");
        int roundsSelectedByPlayer = scanner.nextInt();

        computer = new Computer();
        player = new Player(playerName);

        GameHandler gameHandler = new GameHandler(player, computer);
        gameHandler.playGame(roundsSelectedByPlayer);

        GameRecord gameRecord = new GameRecord(player.getName(), player.getPlayerHistory(), determineFinalResult(player, computer));

        History.addGameRecord(gameRecord);

        System.out.println("\nFinal Score: " + player.getName() + " " + player.getScore() + " - " + computer.getScore() + " Computer");
        goBackToMainMenu();
    }

    private static String determineFinalResult(Player player, Computer computer) {
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
