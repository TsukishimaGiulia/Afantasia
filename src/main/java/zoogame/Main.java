package main.java.zoogame;

import game.GameController;

public class Main {

    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.runGame();
    }
}