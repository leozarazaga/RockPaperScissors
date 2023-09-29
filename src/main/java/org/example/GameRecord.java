package org.example;

import org.example.Menu.RoundResult;

import java.util.List;

public class GameRecord {
    private String playerName;
    private List<RoundResult> roundResults;
    private String finalResult;

    public GameRecord(String playerName, List<RoundResult> roundResults, String finalResult) {
        this.playerName = playerName;
        this.roundResults = roundResults;
        this.finalResult = finalResult;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public String getFinalResult() {
        return finalResult;
    }
}
