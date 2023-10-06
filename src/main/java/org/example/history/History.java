package org.example.history;

import org.example.game.GameRecord;
import org.example.game.RoundResult;
import org.example.menu.MainMenu;

import java.util.*;

public class History {
    private static final Scanner scanner = new Scanner(System.in);
    public static final List<GameRecord> gameRecords = new ArrayList<>(); // Remove static here


    public static void displayGameHistory() {
        System.out.println("\nGame History\n̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ");

        for (GameRecord gameRecord : gameRecords) {
            String playerName = gameRecord.getPlayerName();
            List<RoundResult> playerHistory = gameRecord.getRoundResults();

            System.out.println(playerName + "'s Game\n");

            for (int i = 0; i < playerHistory.size(); i++) {
                RoundResult roundResult = playerHistory.get(i);
                System.out.println("Round " + (i + 1) + ":");
                System.out.println("  " + playerName + ": " + roundResult.getPlayerChoice() + " | " + roundResult.getOpponentName() + ": " + roundResult.getOpponentChoice() + " | Result: " + roundResult.getResult());
            }
        }
        goBackToMainMenu();
    }

    public static void addGameRecord(GameRecord gameRecord) {
        gameRecords.add(gameRecord);
    }

    public static void clearGameHistory() {
        gameRecords.clear();
    }

    public static void goBackToMainMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        MainMenu.mainMenu();
    }
}

