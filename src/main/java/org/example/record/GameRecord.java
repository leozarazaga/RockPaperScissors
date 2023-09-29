package org.example.record;

import org.example.util.RoundResult;

import java.util.List;

public class GameRecord {
    private final String playerName;
    private final List<RoundResult> roundResults;
    private final String finalResult;

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
