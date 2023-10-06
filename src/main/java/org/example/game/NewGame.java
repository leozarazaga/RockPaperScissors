package org.example.game;

import org.example.history.History;
import org.example.menu.MainMenu;
import org.example.opponents.Opponent;
import org.example.player.Player;
import org.example.opponents.*;

import java.util.Scanner;

public class NewGame {
    static Scanner scanner = new Scanner(System.in);
    public static Player player;

    public static void newGame() {
        System.out.println("\nNew Game\n̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);

        while (true) {
            Opponent opponent = selectOpponent();
            int roundsSelectedByPlayer = selectRoundsToPlay();
            playGame(player, opponent, roundsSelectedByPlayer);

            System.out.print("\nPlay another round? (y/n): ");
            String playAnotherRound = scanner.nextLine();
            if (!playAnotherRound.equals("y")) {
                MainMenu.mainMenu();
                break;
            }
        }
    }


    private static Opponent selectOpponent() {
        System.out.println("\nOpponents\n̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ");
        System.out.println("1. Computer");
        System.out.println("2. Chronos");
        System.out.println("3. Namecraft");
        System.out.print("\nChoose your opponent: ");

        int choosingOpponent = scanner.nextInt();
        scanner.nextLine();

        switch (choosingOpponent) {
            case 1:
                return new Computer();
            case 2:
                return new Chronos();
            case 3:
                return new Namecraft(player.getName());
            default:
                System.out.println("Invalid opponent selection.");
                return null;
        }
    }

    private static int selectRoundsToPlay() {
        System.out.print("Rounds to play: ");
        int roundsSelectedByPlayer = scanner.nextInt();
        scanner.nextLine();
        return roundsSelectedByPlayer;
    }

    private static void playGame(Player player, Opponent opponent, int rounds) {
        History.clearGameHistory();

        GameHandler gameHandler = new GameHandler(player, opponent);
        gameHandler.startTheGame(rounds);

        GameRecord gameRecordHistory = new GameRecord(player.getName(), player.getPlayerHistory());
        History.addGameRecord(gameRecordHistory);

        System.out.println("\nFinal Score: " + player.getName() + " " + player.getPlayerScore() + " - " + opponent.getOpponentScore() + " " + opponent.getName());
    }
}

