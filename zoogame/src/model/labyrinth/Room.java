package model.labyrinth;

import model.animal.categories.Animal;
import model.item.Item;
import utility.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

	private String name;
	private List<Item> items;
	private List<Animal> animals;
	private Map<Direction, Door> doors;
	private boolean exit = false;

	public Room(String name) {
		this(name, new ArrayList<>(), new ArrayList<>(), new HashMap<>());
	}

	public Room(String name, Map<Direction, Door> doors) {
		this(name, new ArrayList<>(), new ArrayList<>(), doors);
	}

	public Room(String name, List<Item> items, Map<Direction, Door> doors) {
		this(name, items, new ArrayList<>(), doors);
	}

	public Room(String name, Map<Direction, Door> doors, List<Animal> animals) {
		this(name, new ArrayList<>(), animals, doors);
	}

	public Room(String name, List<Item> items, List<Animal> animals, Map<Direction, Door> doors) {
		this.name = name;
		this.items = items;
		this.animals = animals;
		this.doors = doors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Map<Direction, Door> getDoors() {
		return doors;
	}

	public void setDoors(Map<Direction, Door> doors) {
		this.doors = doors;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public void addItem(Item item){
		items.add(item);
	};
	public Item removeItem(Item item){
		if(items.remove(item)) {
			return item;
		}
		return null;
	};

	@Override
	public String toString() {
		String output = "Room named " + name + ".\n" +
				(items == null || items.isEmpty() ?  "There are no items.\n" : "Items in the room:\n" + Utils.itemsToString(items)) +
				(animals == null || animals.isEmpty() ? "There are no animals" : "Animals in the room: " + animals) + "\n" +
				"List of doors: \n";
		for (String key : doors.keySet()) {
			output += "- " + key.toString() + " door, leading to " + doors.get(key).nextRoom(this).getName() + "\n";
		}
		return output;
	}
}
