package model.game;

import model.item.Item;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;

public class Bag {

	private List<Item> items;
	private final int totalBagSlots;

	public Bag(){
		totalBagSlots = 40;
		items = new ArrayList<>();
	}

	public List<Item> getItems() {
		return items;
	}

	public boolean addItem(Item item){
		if(availableSlots() >= item.getRequiredSlots()){
			items.add(item);
			return true;
		}else{
			throw new RuntimeException("Bag is full");
		}
	}

	public Item removeItem(Item item){
		if(items.remove(item)) {
			return item;
		}
		return null;
	}

	private int availableSlots (){
		int sum = items.stream().mapToInt(Item::getRequiredSlots).sum();
		return totalBagSlots - sum;
	}

	@Override
	public String toString() {
		return "Your bag" + "\n" +
				(items == null || items.isEmpty() ? "There are no items" : "Your items:\n" + Utils.itemsToString(items)) + "\n" +
				"Available slots: " + availableSlots() + ".";
	}
}
