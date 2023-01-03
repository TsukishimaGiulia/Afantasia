package labyrinth.model;

import animal.model.categories.Animal;
import game.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room {

	private String name;
	private List<Item> items = new ArrayList<>();
	private List<Animal> animals = new ArrayList<>();
	private Map<String, Door> doors;

	public Room(String name, List<Item> items, List<Animal> animals, Map<String, Door> doors) {
		this.name = name;
		this.items = items;
		this.animals = animals;
		this.doors = doors;
	}

	public Room(String name, List<Item> items, Map<String, Door> doors) {
		this.name = name;
		this.items = items;
		this.doors = doors;
	}

	public Room(String name, Map<String, Door> doors) {
		this.name = name;
		this.doors = doors;
	}

	public Room(String name, Map<String, Door> doors, List<Animal> animals) {
		this.name = name;
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

	public Map<String, Door> getDoors() {
		return doors;
	}

	public void setDoors(Map<String, Door> doors) {
		this.doors = doors;
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
				(items == null || items.isEmpty() ?  "There are no items" : "Items in the room: " + items) + ".\n" +
				(animals == null || animals.isEmpty() ? "There are no animals" : "Animals in the room: " + animals) + ".\n" +
				"List of doors: \n";
		for (String key : doors.keySet()) {
			output += "- " + key.toString() + " door, leading to " + doors.get(key).nextRoom(this).getName();
		}
		return output;
	}
}
