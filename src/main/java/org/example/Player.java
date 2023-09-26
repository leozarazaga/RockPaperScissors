package org.example;

import org.example.Moves.MoveStrategy;

public class Player {
    private MoveStrategy moveStrategy;
    private String name;

    public Player(String name){
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }

    //Setters
    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void play(){
        System.out.println(name + "plays: ");
        moveStrategy.moveAttack();
    }
}
