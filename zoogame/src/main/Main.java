package main;

import game.GameController;
import model.game.Bag;
import model.item.HealthyItem;
import model.item.Item;
import model.game.Player;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.runGame();
    }
}