package org.example.Menu;

import org.example.Player;

import java.util.*;

public class History {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, List<RoundResult>> playerHistoryMap = new HashMap<>();

    public static void displayGameHistory() {
        System.out.println("\nGame History\n̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ");

        for (Map.Entry<String, List<RoundResult>> entry : playerHistoryMap.entrySet()) {
            String playerName = entry.getKey();
            List<RoundResult> playerHistory = entry.getValue();
            System.out.println(playerName + "'s Games: \n- - - - - - ");

            for (int i = 0; i < playerHistory.size(); i++) {
                RoundResult roundResult = playerHistory.get(i);
                System.out.println("Round " + (i + 1) + ":");
                System.out.println(playerName + ": " + roundResult.getPlayerChoice() + " | Computer: " + roundResult.getComputerChoice() + " | Result: " + roundResult.getResult());
                //System.out.println(roundResult.getResult());
            }
        }

        goBackToMainMenu();
    }

    public static void addToGameHistory(Player player, RoundResult roundResult) {
        String playerName = player.getName();

        if (playerHistoryMap.containsKey(playerName)) {
            playerHistoryMap.get(playerName).add(roundResult);
        } else {
            List<RoundResult> playerHistory = new ArrayList<>();
            playerHistory.add(roundResult);
            playerHistoryMap.put(playerName, playerHistory);
        }

    }

    public static void goBackToMainMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        MainMenu.mainMenu();
    }

}

 /* List<RoundResult> playerHistory = player.getPlayerHistory();
        List<RoundResult> computerHistory = computer.getComputerHistory();

        for (int i = 0; i < playerHistory.size(); i++) {
            RoundResult playerRound = playerHistory.get(i);
            RoundResult computerRound = computerHistory.get(i);

            System.out.println("Round " + (i + 1) + ":");
            System.out.println(player.getName() + ": " + playerRound.getPlayerChoice() + " | Computer: " + playerRound.getComputerChoice() + " | Result: " + playerRound.getResult());
            //  System.out.println("  Computer: " + computerRound.getPlayerChoice() + " | Player: " + playerRound.getComputerChoice() + " | Result: " + computerRound.getResult());
        }
 */
