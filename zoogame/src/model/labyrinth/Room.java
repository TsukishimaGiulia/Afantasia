package model.labyrinth;

import exception.ItemNotFoundException;
import lombok.Getter;
import lombok.Setter;
import model.animal.categories.Animal;
import model.item.Item;
import utils.StringifyUtil;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
public class Room {

	private String name;
	private List<Item> items;
	private List<Animal> animals;
	private Map<Direction, Door> doors;
	@Setter
	private boolean exit = false;

	public Room(String name) {
		this(name, new ArrayList<>(), new ArrayList<>(), new EnumMap<>(Direction.class));
	}

	public Room(String name, Map<Direction, Door> doors) {
		this(name, new ArrayList<>(), new ArrayList<>(), doors);
	}

	public Room(String name, List<Item> items, Map<Direction, Door> doors) {
		this(name, items, new ArrayList<>(), doors);
	}

	public Room(String name, Map<Direction, Door> doors, List<Animal> animals) {
		this(name, new ArrayList<>(), animals, doors);
	}

	public Room(String name, List<Item> items, List<Animal> animals, Map<Direction, Door> doors) {
		this.name = name;
		this.items = items;
		this.animals = animals;
		this.doors = doors;
	}


	public void addItem(Item item){
		items.add(item);
	}

	public Item removeItem(String itemName) throws ItemNotFoundException {
		Item item = items.stream()
				.filter(i -> i.getName().equals(itemName))
				.findFirst()
				.orElse(null);
		if(items.remove(item)) {
			return item;
		}
		throw new ItemNotFoundException(itemName);
	}

	public Room goToNextRoom(String direction){
		try{
			Door requestedDoor = this.doors.get(Direction.valueOf(direction.toUpperCase()));
			if(requestedDoor == null){
				return this;
			}
			return requestedDoor.nextRoom(this);
		}catch(IllegalArgumentException e){
			return this;
		}
	}

	public String description() {
		return "Room named " + name + "." +
				"\nItems in the room:" + StringifyUtil.listOfItems(items) +
				"\nAnimals in the room: " + StringifyUtil.listOfAnimals(animals) +
				"\nList of Doors: " + mapOfDoorsToString();
	}

	private String mapOfDoorsToString(){
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Direction,Door> entry : doors.entrySet()) {
			builder.append("\n- ").append(entry.getKey().getName()).append(" door, leading to ").append(entry.getValue().nextRoom(this).name);
		}
		return builder.toString();
	}

}
