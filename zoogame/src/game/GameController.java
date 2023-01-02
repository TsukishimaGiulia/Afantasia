package game;

import game.console.InputController;
import game.model.Item;
import game.model.Player;
import map.model.Door;
import map.model.Room;

import java.util.Optional;
import java.util.stream.Collectors;

public class GameController {

	private final Room entry;
	private final Player player;

	public GameController(Room entry, Player player) {
		this.entry = entry;
		this.player = player;
	}

	public void runGame() {
		Room currentRoom = entry;
		boolean gameEnded = false;

		System.out.println("Welcome to Afantasia, our fantastic world without fantasy!\n" +
				"You are now in the entry room and you have to find the exit.\n" +
				"In your path you will find animals that can give you suggestions on what to do, and objects to collect.\n" +
				"You can type your commands using the keyboard: write help for a list of possible commands.\n\n" +
				currentRoom.toString() + "\n");


		while(!gameEnded) {
			String output = "";
			String input;
//			System.out.println("Where are you going to go?");

			System.out.print(">");
			input = InputController.readString();
			String itemName;
			Optional<Item> itemOptional;


			try {
				switch(input.toLowerCase().split(" ")[0]){

					case "go":
						Room room = goToNextRoom(currentRoom, input.toLowerCase().split(" ")[1]);
						if(room.equals(currentRoom) || room == null){
							output = "The selected room does not exist. You still are in " + currentRoom.getName() + ".";
						}
						else{
							currentRoom = room;
							output = "You just stepped into " + currentRoom.toString();
						}
						break;
					case "look":
						output = currentRoom.toString();
						break;
					case "bag":
						output = player.getBag().toString();
						break;
					case "get":
						itemName = input.split(" ")[1];
						itemOptional = currentRoom.getItems().stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst();
						if(itemOptional.isPresent()){
							currentRoom.removeItem(itemOptional.get());
							player.getBag().addItem(itemOptional.get());
							output = "You have put " + itemName + " into your bag.";
						}else {
							output = "There isn't any " + itemName + " in this room.";
						}
						break;
					case "drop":
						itemName = input.split(" ")[1];
						itemOptional = player.getBag().getItems().stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst();
						if(itemOptional.isPresent()){
							player.getBag().dropItem(itemOptional.get());
							currentRoom.addItem(itemOptional.get());
							output = "You have dropped " + itemName + ".";
						}else {
							output = "There isn't any " + itemName + " in your bag.";
						}
						break;
					case "help":
						output = "- go: lets you move through rooms, specifying the direction (north, south, east, west) as a parameter (ex: go north);\n" +
						"- look: gives you the description of the room, including items and animals present;\n" +
						"- bag: gives you the list of items in your bag;\n" +
						"- get: lets you pick up an item selected as a parameter from the room and put it in your bag (ex: get itemName);\n" +
						"- drop: lets you drop an item selected as a parameter from your bag and leave it in the current room (ex: drop itemName);\n" +
						"- exit: ends the game.";
						break;
					case "exit":
						gameEnded = true;
						break;
					default:
						output = "Command not valid, type 'help' to see the command list.";
						break;
				}
			}catch(IndexOutOfBoundsException e){
				output = "You must specify a parameter for the command " + input + ".";
			}

			System.out.println(output + "\n");
		}
	}

	// prevediamo di utilizzare il seguente metodo solo dentro RunGame(), quindi lo mettiamo private
	private Room goToNextRoom(Room currentRoom, String direction){
		Door requestedDoor = currentRoom.getDoors().get(direction);
		if(requestedDoor == null) {
			return currentRoom;
		}
		Room requestedRoom = requestedDoor.nextRoom(currentRoom);
		return requestedRoom;
	}
}
