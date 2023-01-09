package main;

import model.animal.Lion;
import model.animal.categories.Animal;
import game.GameController;
import model.game.Bag;
import model.item.Item;
import model.game.Player;
import model.labyrinth.Direction;
import model.labyrinth.Door;
import model.labyrinth.Labyrinth;
import model.labyrinth.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Bag bag = new Bag();
        Player player = new Player("Giulia", 100, bag);
        Item item = new Item("una cosa","una cosa", 2);
        bag.addItem(item);



        GameController gameController = new GameController(player);

        gameController.runGame();
    }
}