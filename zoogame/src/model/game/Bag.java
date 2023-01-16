package model.game;

import exception.FullBagException;
import exception.ItemNotFoundException;
import model.item.Item;
import utils.Stringify;
import utils.Search;

import java.util.ArrayList;
import java.util.List;

public class Bag {

	private List<Item> items;
	private int availableSlots;

	public Bag(){
		availableSlots = 40;
		items = new ArrayList<>();
	}

	public List<Item> getItems() {
		return items;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public boolean addItem(Item item) throws FullBagException{
		if(availableSlots >= item.getRequiredSlots()){
			items.add(item);
			availableSlots -= item.getRequiredSlots();
			return true;
		}else{
			throw new RuntimeException("Bag is full");
		}
	}

	public Item removeItem(String itemName) throws ItemNotFoundException {
		Item item = Search.itemByName(itemName,items);
		if(items.remove(item)) {
			availableSlots += item.getRequiredSlots();
			return item;
		}
		return null;
	}

	public String description() {
		return "Your bag" +
				Stringify.listOfItems(items) + "\n" +
				"Available slots: " + availableSlots + ".";
	}
}
