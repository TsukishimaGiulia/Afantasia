package model.game;

import exception.FullBagException;
import exception.ItemNotFoundException;
import model.item.Item;
import java.util.List;

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

	public boolean addItemToBag(Item item) throws FullBagException {
		return bag.addItem(item);
	}

	public Item removeItemFromBag(String itemName) throws ItemNotFoundException {
		return bag.removeItem(itemName);
	}

	public List<Item> getAllItemsFromBag() {
		return bag.getItems();
	}
}
