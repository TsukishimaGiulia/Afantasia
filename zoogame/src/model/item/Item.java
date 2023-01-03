package model.item;

public class Item {

	private String name;
	private String description;
	private int requiredSlots;

	public Item(String name, String description, int requiredSlots) {
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

	public void setRequiredSlots(int requiredSlots) {
		this.requiredSlots = requiredSlots;
	}

	@Override
	public String toString() {
		return "Item: " +
				"name= " + name + " " +
				", description= " + description + " " +
				", requiredSlots=" + requiredSlots + ".";
	}
}
