package main;

import game.GameController;
import model.game.Bag;
import model.item.HealthyItem;
import model.item.Item;
import model.game.Player;

public class Main {

    public static void main(String[] args) {

        Bag bag = new Bag();
        Player player = new Player("Giulia", 100, bag);
        Item item = new HealthyItem("apple","apple", 2);
        bag.addItem(item);
        bag.addItem(item);

        GameController gameController = new GameController(player);

            gameController.runGame();

    }
}