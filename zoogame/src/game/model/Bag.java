package game.model;

import java.util.List;

public class Bag {

	private List<Item> items;
	private int totalBagSlots;

	public Bag(List<Item> items, int totalBagSlots) {
		this.items = items;
		this.totalBagSlots = totalBagSlots;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getTotalBagSlots() {
		return totalBagSlots;
	}

	@Override
	public String toString() {
		return "Bag{" +
				"items=" + items +
				", totalBagSlots=" + totalBagSlots +
				'}';
	}

	public void addItem(Item item){};

	public Item dropItem(Item item){
		return null;
	};
}
