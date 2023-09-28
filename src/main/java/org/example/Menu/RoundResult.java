package org.example.Menu;

public class RoundResult {
    private final String playerChoice;
    private final String computerChoice;
    private final String result;

    public RoundResult(String playerChoice, String computerChoice, String result) {
        this.playerChoice = playerChoice;
        this.computerChoice = computerChoice;
        this.result = result;
    }

    // Getters
    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String getResult() {
        return result;
    }

}

