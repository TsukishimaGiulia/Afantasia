package model.game;

import exception.FullBagException;
import exception.ItemNotFoundException;
import model.item.Item;
import utils.StringifyUtil;
import java.util.ArrayList;
import java.util.List;

public class Bag {

	private List<Item> items;
	private int availableSlots;

	public Bag(){
		availableSlots = 10;
		items = new ArrayList<>();
	}

	public boolean addItem(Item item) throws FullBagException{
		if(availableSlots >= item.getRequiredSlots()){
			items.add(item);
			availableSlots -= item.getRequiredSlots();
			return true;
		}else{
			throw new FullBagException();
		}
	}

	public Item removeItem(String itemName) throws ItemNotFoundException {
		Item item = items.stream()
				.filter(i -> i.getName().equals(itemName))
				.findFirst()
				.orElse(null);
		if((item != null) && items.remove(item)) {
			availableSlots += item.getRequiredSlots();
			return item;
		}
		throw new ItemNotFoundException(itemName);
	}

	public String description() {
		return "Your bag: " +
				StringifyUtil.listOfItems(items) + "\n" +
				"Available slots: " + availableSlots + ".";
	}
}
