package org.example.player;

import org.example.interfaces.MoveStrategy;
import org.example.menu.MainMenu;
import org.example.player.moves.Paper;
import org.example.player.moves.Rock;
import org.example.player.moves.Scissors;
import org.example.game.RoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private final String name;
    private int playerScore;
    private final List<RoundResult> playerHistory;

    private int totalWins;
    private int winsAgainstComputer;
    private int winsAgainstChronos;
    private int winsAgainstNamecraft;

    public Player(String name) {
        this.name = name;
        this.playerScore = 0;
        this.playerHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void incrementPlayerScore() {
        playerScore++;
        totalWins++;
    }

    public MoveStrategy getPlayerChoice(Scanner scanner) {
        System.out.println("+------------------------------------+");
        System.out.println("|  1. Rock | 2. Paper | 3. Scissors  |");
        System.out.println("+------------------------------------+");

        System.out.print("Choose your move: ");
        int playerChoice = scanner.nextInt();

        switch (playerChoice) {
            case 1:
                return new Rock();
            case 2:
                return new Paper();
            case 3:
                return new Scissors();
            default:
                System.out.print("Invalid choice. Select 1, 2, or 3.\n");
                return getPlayerChoice(scanner);
        }
    }

    public List<RoundResult> getPlayerHistory() {
        return playerHistory;
    }


    //Statistics
    public double getOverallWinPercentage() {
        int totalGames = playerHistory.size();
        if (totalGames == 0) {
            return 0.0;
        }
        double winPercentage = (double) totalWins / totalGames * 100;
        return Math.floor(winPercentage * 100) / 100; // Round down to two decimal places
    }

    public int countGamesAgainstComputer() {
        return countGamesAgainstOpponent("Computer");
    }

    public int countGamesAgainstChronos() {
        return countGamesAgainstOpponent("Chronos");
    }

    public int countGamesAgainstNamecraft() {
        return countGamesAgainstOpponent("Namecraft");
    }

    public double getWinPercentageAgainstComputer() {
        int totalGamesAgainstComputer = countGamesAgainstComputer();
        if (totalGamesAgainstComputer == 0) {
            return 0.0;
        }
        double winPercentage = (double) winsAgainstComputer / totalGamesAgainstComputer * 100;
        return Math.floor(winPercentage * 100) / 100;
    }

    public double getWinPercentageAgainstChronos() {
        int totalGamesAgainstChronos = countGamesAgainstChronos();
        if (totalGamesAgainstChronos == 0) {
            return 0.0;
        }
        double winPercentage = (double) winsAgainstChronos / totalGamesAgainstChronos * 100;
        return Math.floor(winPercentage * 100) / 100;
    }

    public double getWinPercentageAgainstNamecraft() {
        int totalGamesAgainstNamecraft = countGamesAgainstNamecraft();
        if (totalGamesAgainstNamecraft == 0) {
            return 0.0;
        }
        double winPercentage = (double) winsAgainstNamecraft / totalGamesAgainstNamecraft * 100;
        return Math.floor(winPercentage * 100) / 100;
    }

    private int countGamesAgainstOpponent(String opponent) {
        return (int) playerHistory.stream()
                .filter(result -> result.getOpponentName().equals(opponent))
                .count();
    }


    public void addToPlayerHistory(String playerChoice, String opponentChoice, String gameRoundResult, String opponentName) {
        playerHistory.add(new RoundResult(playerChoice, opponentChoice, gameRoundResult, opponentName));

        if (gameRoundResult.equals("Player wins!")) {
            switch (opponentName) {
                case "Computer":
                    winsAgainstComputer++;
                    break;
                case "Chronos":
                    winsAgainstChronos++;
                    break;
                case "Namecraft":
                    winsAgainstNamecraft++;
                    break;
            }
        }
    }



    public void displayStatistics() {
        System.out.println("\nStatistics\n̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ̅ ");
        System.out.println("Total Wins: " + totalWins);

        double overallWinPercentage = getOverallWinPercentage();
        System.out.println("Overall win percentage: " + overallWinPercentage + "%");

        int gamesAgainstComputer = countGamesAgainstComputer();
        double winPercentageAgainstComputer = getWinPercentageAgainstComputer();
        System.out.println("Win percentage against Computer: " + winPercentageAgainstComputer + "% (Games: " + gamesAgainstComputer + ")");

        int gamesAgainstChronos = countGamesAgainstChronos();
        double winPercentageAgainstChronos = getWinPercentageAgainstChronos();
        System.out.println("Win percentage against Chronos: " + winPercentageAgainstChronos + "% (Games: " + gamesAgainstChronos + ")");

        int gamesAgainstNamecraft = countGamesAgainstNamecraft();
        double winPercentageAgainstNamecraft = getWinPercentageAgainstNamecraft();
        System.out.println("Win percentage against Namecraft: " + winPercentageAgainstNamecraft + "% (Games: " + gamesAgainstNamecraft + ")");

        goBackToMainMenu();
    }


    public static void goBackToMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        MainMenu.mainMenu();
    }
}