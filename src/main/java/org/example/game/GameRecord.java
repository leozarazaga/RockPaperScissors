package org.example.game;

import java.util.List;

public class GameRecord {
    private final String playerName;
    private final List<RoundResult> roundResults;

    public GameRecord(String playerName, List<RoundResult> roundResults) {
        this.playerName = playerName;
        this.roundResults = roundResults;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
