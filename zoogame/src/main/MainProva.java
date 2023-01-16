package main;

import command.Command;
import command.CommandFactory;
import game.GameController;

public class MainProva {
    public static void main(String[] args) {
        GameController gc = GameController.getInstance();
        gc.runGame();
    }
}
