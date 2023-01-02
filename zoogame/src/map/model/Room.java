package map.model;

import animal.model.categories.Animal;
import game.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

	private String name;
	private List<Item> items = new ArrayList<>();
	private List<Animal> animals = new ArrayList<>();
	private Map<String,Room> adjoiningRooms;

	public Room(String name, List<Item> items, List<Animal> animals, Map<String, Room> adjoiningRooms) {
		this.name = name;
		this.items = items;
		this.animals = animals;
		this.adjoiningRooms = adjoiningRooms;
	}

	public Room(String name, List<Item> items, Map<String, Room> adjoiningRooms) {
		this.name = name;
		this.items = items;
		this.adjoiningRooms = adjoiningRooms;
	}

	public Room(String name, Map<String, Room> adjoiningRooms) {
		this.name = name;
		this.adjoiningRooms = adjoiningRooms;
	}

	public Room(String name, Map<String, Room> adjoiningRooms, List<Animal> animals) {
		this.name = name;
		this.animals = animals;
		this.adjoiningRooms = adjoiningRooms;
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

	public Map<String, Room> getAdjoiningRooms() {
		return adjoiningRooms;
	}

	public void setAdjoiningRooms(Map<String, Room> adjoiningRooms) {
		this.adjoiningRooms = adjoiningRooms;
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
		return "Room named " + name + ".\n" +
				(items == null ? "There are no items" : "Items in the room: " + items) + ".\n" +
				(animals == null ? "There are no animals" : "Animals in the room: " + animals) + ".";
	}
}
