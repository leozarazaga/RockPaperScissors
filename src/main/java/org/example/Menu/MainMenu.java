package org.example.Menu;

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
        System.out.println("1.New Game\n2.History\n3.Stats ");

        System.out.print("\nChoose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                NewGame.newGame();
                break;
            case 2:

                break;
            case 3:
                programActive = false;
                System.out.println("Closing program...");
                break;
            default:
                System.out.println("Wrong input!");

        }

    }

}
