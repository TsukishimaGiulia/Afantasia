package model.game;

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

	//TODO: gestire exception
	public boolean addItem(Item item){
		if(availableSlots >= item.getRequiredSlots()){
			items.add(item);
			availableSlots -= item.getRequiredSlots();
			return true;
		}else{
			throw new RuntimeException("Bag is full");
		}
	}

	//TODO: gestire exception
	public Item removeItem(String itemName){
		Item item = Search.itemByName(itemName,items);
		if(items.remove(item)) {
			availableSlots += item.getRequiredSlots();
			return item;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Your bag" + "\n" +
				Stringify.listOfItems(items) + "\n" +
				"Available slots: " + availableSlots + ".";
	}
}
