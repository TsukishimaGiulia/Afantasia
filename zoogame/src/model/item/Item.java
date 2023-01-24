package model.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.game.Player;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public abstract class Item {

	private String name;
	private String description;
	@Setter(AccessLevel.NONE)
	private int requiredSlots;

	public abstract String use(Player player);

	@Override
	public String toString() {
		return "Item: " +
				"name= " + name + " " +
				", description= " + description + " " +
				", requiredSlots=" + requiredSlots + ".";
	}
}
