package org.example.Menu;

import org.example.GameRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class History {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<GameRecord> gameRecords = new ArrayList<>();

    public static void displayGameHistory() {
        System.out.println("\nGame History\n̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ");

        for (GameRecord gameRecord : gameRecords) {
            String playerName = gameRecord.getPlayerName();
            List<RoundResult> playerHistory = gameRecord.getRoundResults();

            System.out.println(playerName + "'s Game\n");

            for (int i = 0; i < playerHistory.size(); i++) {
                RoundResult roundResult = playerHistory.get(i);
                System.out.println("Round " + (i + 1) + ":");
                System.out.println("  " + playerName + ": " + roundResult.getPlayerChoice() + " | Computer: " + roundResult.getComputerChoice() + " | Result: " + roundResult.getResult());
            }

            System.out.println("\nFinal Result: " + gameRecord.getFinalResult());
            System.out.println("═════════════════════════════════════════");
        }

        goBackToMainMenu();
    }
    public static void addGameRecord(GameRecord gameRecord) {
        gameRecords.add(gameRecord);
    }

    public static void goBackToMainMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        MainMenu.mainMenu();
    }
}
