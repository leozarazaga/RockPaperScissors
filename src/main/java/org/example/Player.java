package org.example;

import org.example.Moves.MoveStrategy;
import org.example.Moves.Paper;
import org.example.Moves.Rock;
import org.example.Moves.Scissors;

import java.util.Scanner;

public class Player {

    final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementPlayerScore() {
        score++;
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
                System.out.print("Invalid choice. Select 1, 2, or 3.");
                return getPlayerChoice(scanner);
        }
    }

}
