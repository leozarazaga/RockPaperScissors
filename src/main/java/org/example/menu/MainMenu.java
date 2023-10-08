package org.example.menu;


import org.example.game.NewGame;
import org.example.history.History;
import org.example.player.Player;

import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static boolean programActive = true;

    public static void mainMenu() {

        if (programActive) {
            System.out.println("╔══════════════════════╗");
            System.out.println("  ROCK PAPER SCISSORS");
            System.out.println("╚══════════════════════╝");
            programActive = false;
        }


        System.out.println("\n\t MAIN MENU\n\t̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ");
        System.out.println("1.New Game\n2.History\n3.Stats\n4.Exit ");

        System.out.print("\nChoose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                NewGame.newGame();
                break;
            case 2:
                History.displayGameHistory();
                break;
            case 3:
                NewGame.player.displayStatistics();
                break;
            case 4:
                programActive = false;
                System.out.println("Closing program...");
                break;
            default:
                System.out.println("Wrong input!");

        }

    }
}
