package org.example.Menu;

import org.example.GameLogic.GameLogic;
import org.example.Moves.MoveStrategy;
import org.example.Moves.Paper;
import org.example.Moves.Rock;
import org.example.Moves.Scissors;
import org.example.Player;

import java.util.Random;
import java.util.Scanner;

public class NewGame {

    public static void newGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nNew Game\n̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Rounds to play: ");
        int roundsSelectedByPlayer = scanner.nextInt();

        playRounds(playerName, roundsSelectedByPlayer, scanner);
    }


    private static void playRounds(String playerName, int roundsSelectedByPlayer, Scanner scanner) {
        int roundCount = 0;
        while (roundCount < roundsSelectedByPlayer) {
            roundCount++;

            MoveStrategy playerChoice = getPlayerChoice(scanner);
            MoveStrategy computerChoice = generateComputerMove();

            System.out.println("\nYou selected: " + playerChoice.moveAttack());
            System.out.println("Computer selected: " + computerChoice.moveAttack());

            GameLogic game = new GameLogic();
            game.PlayGame(playerChoice, computerChoice);
        }
    }

    private static MoveStrategy generateComputerMove() {
        Random random = new Random();
        int computerChoice = random.nextInt(3) + 1;

        switch (computerChoice) {
            case 1:
                return new Rock();
            case 2:
                return new Paper();
            case 3:
                return new Scissors();
        }
        return null;
    }

    private static MoveStrategy getPlayerChoice(Scanner scanner) {
        System.out.println("\n1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
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
                System.out.println("Invalid choice. Select 1, 2, or 3.");
                return getPlayerChoice(scanner);
        }
    }
}
