package model.game;

import model.item.Item;

import java.util.List;
import java.util.Optional;

public class Player {

	private String name;
	private int lifePoints;
	private Bag bag;

	public Player(String name, int lifePoints, Bag bag) {
		this.name = name;
		this.lifePoints = lifePoints;
		this.bag = bag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public Bag getBag() {
		return bag;
	}

	public boolean addItemToBag(Item item) {
		return bag.addItem(item);
	}

	public Item removeItemFromBag(String itemName) {
		return bag.removeItem(itemName);
	}

	public List<Item> getAllItemsFromBag() {
		return bag.getItems();
	}
}
