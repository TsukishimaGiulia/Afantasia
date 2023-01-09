package model.game;

import model.item.Item;
import utility.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {

	private List<Item> items = new ArrayList<>();
	private final int totalBagSlots = 5;

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
	};
	public Item dropItem(Item item){
		if(items.remove(item)) {
			return item;
		}
		return null;
	};

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
