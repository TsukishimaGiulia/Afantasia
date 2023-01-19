package model.item;

import model.game.Player;

public abstract class Item {

	private String name;
	private String description;
	private int requiredSlots;

	protected Item(String name, String description, int requiredSlots) {
		this.name = name;
		this.description = description;
		this.requiredSlots = requiredSlots;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRequiredSlots() {
		return requiredSlots;
	}

	public abstract String use(Player player);

	@Override
	public String toString() {
		return "Item: " +
				"name= " + name + " " +
				", description= " + description + " " +
				", requiredSlots=" + requiredSlots + ".";
	}
}
