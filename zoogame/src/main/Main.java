package main;

import animal.model.Lion;
import animal.model.categories.Animal;
import game.GameController;
import game.model.Bag;
import game.model.Item;
import game.model.Player;
import map.model.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Room> mentry = new HashMap<>();
        Map<String, Room> m1 = new HashMap<>();
        Map<String, Room> m5 = new HashMap<>();

        List<Animal> animals1 = new ArrayList<>();
        Lion leone = new Lion("Simba", "pizza", 10, LocalDate.now(), 30.80, 50.30, 15.00);
        animals1.add(leone);

        Room entry = new Room("entry", mentry, animals1);
        Room r1 = new Room("1", m1);
        Room r5 = new Room("5", m5);

        mentry.put("north", r1);
        m1.put("north", r5);
        m1.put("south", entry);
        m5.put("south", r1);

        Bag bag = new Bag();

        Player player = new Player("Giulia", 100, bag);

        Item item = new Item("cosa","una cosa", 2);

       // System.out.println(bag.availableSlots());
        entry.addItem(item);
        bag.addItem(item);

        GameController gc = new GameController(entry, player);

        gc.runGame();
    }
}