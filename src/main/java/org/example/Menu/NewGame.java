package org.example.Menu;

import org.example.Computer;
import org.example.GameLogic.GameLogic;
import org.example.Moves.MoveStrategy;
import org.example.Player;
import java.util.Scanner;


public class NewGame {

    static Scanner scanner = new Scanner(System.in);

    public static void newGame() {
        //REFACTOR THIS CODE LATER ON!! (No spaghetti code here!)

        System.out.println("\nNew Game\n̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Rounds to play: ");
        int roundsSelectedByPlayer = scanner.nextInt();

        Computer computer = new Computer();
        Player player = new Player(playerName);



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

            player.addToPlayerHistory(playerChoice.moveAttack(),computerChoice.moveAttack(), roundResult);
            computer.addToComputerHistory(computerChoice.moveAttack(), playerChoice.moveAttack(), roundResult);

            if (roundResult.equals("Player wins!")) {
                player.incrementPlayerScore();
            } else if (roundResult.equals("Computer wins!")) {
                computer.incrementComputerScore();
            }

        }

        History.displayGameHistory(player, computer);

        System.out.println("\nFinal Score: " + player.getName() + " " + player.getScore() + " - " + computer.getScore() + " Computer");
        goBackToMainMenu();
    }

    public static void goBackToMainMenu(){
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        MainMenu.mainMenu();
    }

}
