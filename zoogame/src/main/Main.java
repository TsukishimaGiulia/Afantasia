package main;

import model.animal.Lion;
import model.animal.categories.Animal;
import game.GameController;
import model.game.Bag;
import model.item.Item;
import model.game.Player;
import model.labyrinth.Door;
import model.labyrinth.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Door> dentry = new HashMap<>();
        Map<String, Door> d1 = new HashMap<>();
        Map<String, Door> d5 = new HashMap<>();

        List<Animal> animals1 = new ArrayList<>();
        Lion leone = new Lion("Simba", "pizza", 10, LocalDate.now(), 30.80, 50.30, 15.00);
        animals1.add(leone);

        Room entry = new Room("entry", dentry, animals1);
        Room r1 = new Room("1", d1);
        Room r5 = new Room("5", d5);

        Door door1 = new Door(true,entry,r1);
        Door door2 = new Door(true, r1,r5);

        dentry.put("north", door1);
        d1.put("north", door2);
        d1.put("south", door1);
        d5.put("south", door2);

        Bag bag = new Bag();

        Player player = new Player("Giulia", 100, bag);

        Item item = new Item("cosa","una cosa", 2);

       // System.out.println(bag.availableSlots());
        entry.addItem(item);
        bag.addItem(item);

        GameController gc = new GameController(entry, player);

//        gc.runGame();

        gc.generateLabyrinth(18);

    }
}