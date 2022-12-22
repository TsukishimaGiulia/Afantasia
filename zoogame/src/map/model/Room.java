package map.model;

import animal.model.categories.Animal;
import game.model.Item;

import java.util.List;
import java.util.Map;

public class Room {

	private String name;
	private List<Item> items;
	private List<Animal> animals;
	private Map<String,Room> adjoiningRooms;

	public Room(String name, List<Item> items, List<Animal> animals, Map<String, Room> adjoiningRooms) {
		this.name = name;
		this.items = items;
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

	public void setItems(List<Item> items) {
		this.items = items;
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

	public void addItem(Item item){};
	public Item removeItem(Item item){
		return null;
	};
}
