package org.example.opponents;

public interface Opponent {
    String handMove();
    String getName();

     int getOpponentScore();

    void incrementOpponentScore();

}
