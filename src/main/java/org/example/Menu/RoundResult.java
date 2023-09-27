package org.example.Menu;

public class RoundResult {
    private String playerChoice;
    private String computerChoice;
    private String result;

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

