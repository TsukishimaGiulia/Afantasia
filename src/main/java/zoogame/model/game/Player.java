package model.game;

import exception.FullBagException;
import exception.ItemNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.item.Item;
@AllArgsConstructor
@Getter
@Setter
public class Player {


	private String name;

	private int lifePoints;
	@Setter(AccessLevel.NONE)
	private Bag bag;

	public boolean addItemToBag(Item item) throws FullBagException {
		return bag.addItem(item);
	}

	public Item removeItemFromBag(String itemName) throws ItemNotFoundException {
		return bag.removeItem(itemName);
	}
}
