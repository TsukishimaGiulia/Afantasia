package game.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {

	private List<Item> items = new ArrayList<>();
	private final int totalBagSlots = 40;

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Your bag" + "\n" +
				(items == null ? "There are no items" : "Your items: " + items) + ".\n" +
				"Available slots: " + availableSlots() + ".";
	}

	public void addItem(Item item){
			items.add(item);
	};
	public Item dropItem(Item item){
		if(items.remove(item)) {
			return item;
		}
		return null;
	};

	public int availableSlots (){
		int sum = items.stream().mapToInt(Item::getRequiredSlots).sum();
		return totalBagSlots - sum;
	}
}
