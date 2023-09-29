package org.example.menu;

import java.util.Scanner;

public class NewGameSubmenu {
    static Scanner scanner = new Scanner(System.in);

    public static void newGameSubmenu() {

        System.out.print("""
                                
                New Game
                ̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅̅\s
                1. vs Randomizer
                2. vs Chronos
                3. vs Namecraft
                4. ↩ Back to main menu

                Choose your opponent:\s""");

        int chooseAnOption = scanner.nextInt();

        switch (chooseAnOption) {
            case 1:
                NewGame.newGame();
                break;
            case 2:
                System.out.println("VS TIME!");
                break;
            case 3:
                System.out.println("VS NAME");
                break;
            case 4:
                MainMenu.mainMenu();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }


}
