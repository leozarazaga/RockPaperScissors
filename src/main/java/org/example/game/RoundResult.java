package org.example.game;

public class RoundResult {
    private final String playerChoice;
    private final String opponentChoice;
    private final String result;

    private final String opponentName;

    public RoundResult(String playerChoice, String opponentChoice, String result, String opponentName) {
        this.playerChoice = playerChoice;
        this.opponentChoice = opponentChoice;
        this.result = result;

        this.opponentName = opponentName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getOpponentChoice() {
        return opponentChoice;
    }

    public String getResult() {
        return result;
    }
}
