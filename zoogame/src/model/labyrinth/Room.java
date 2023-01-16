package model.labyrinth;

import exception.FullBagException;
import exception.ItemNotFoundException;
import model.animal.categories.Animal;
import model.item.Item;
import utils.Stringify;
import utils.Search;

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
	}

	public Item removeItem(String itemName) throws ItemNotFoundException {
		Item item = Search.itemByName(itemName, items);
		if(items.remove(item)) {
			return item;
		}
		return null;
	}

	public String description() {
		return "Room named " + name + "." +
				"\nItems in the room:" + Stringify.listOfItems(items) +
				"\nAnimals in the room: " + Stringify.listOfAnimals(animals) +
				"\nList of Doors: " + mapOfDoorsToString();
	}

	private String mapOfDoorsToString(){
		String output = "";
		for (Direction key : doors.keySet()) {
			output += "\n- " + key.getName() + " door, leading to " + doors.get(key).nextRoom(this).getName();
		}
		return output;
	}
}
