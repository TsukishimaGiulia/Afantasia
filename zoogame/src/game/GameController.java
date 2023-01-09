package game;

import game.console.InputController;
import model.item.Item;
import model.game.Player;
import model.labyrinth.Door;
import model.labyrinth.Labyrinth;
import model.labyrinth.Room;

import java.util.*;

public class GameController {

	private final Player player;

	public GameController(Player player) {
		this.player = player;
	}

	public void runGame() {

		boolean gameEnded = false;
		String input;
		int labyrinthDimension = 0;
		Labyrinth labyrinth;
		Room currentRoom;

		System.out.println("Welcome to Afantasia, our fantastic world without fantasy!\n" +
				"In this game, you're lost in a labyrinth and you have to find the exit.\n" +
				"In your path you will find animals that can give you suggestions on what to do, and objects to collect.\n");

		do{
			System.out.println("Please insert a number between 5 and 100 to define the dimension of the labyrinth: ");
			System.out.print(">");
			input = InputController.readString();
			try {
				labyrinthDimension = Integer.parseInt(input);
			}catch(NumberFormatException e){
				System.err.println("You must type a number!!!!!");
			}
			labyrinth = new Labyrinth(labyrinthDimension);
			labyrinth.addAnimalsAndItemsToLabyrinth();
		}while(labyrinthDimension>100 || labyrinthDimension<5);

		currentRoom = labyrinth.getRooms().get(0);

		System.out.println("Congratulations, a labyrinth with " + labyrinth.getRooms().size() + " rooms has been created ;-) .\n" +
				"You are now in the entry room. You can type your commands using the keyboard: write help for a list of possible commands.\n\n" +
				currentRoom.toString() + "\n");

		while(!gameEnded) {
			String output = "";

			System.out.print(">");
			input = InputController.readString();
			String[] splitInput = input.toLowerCase().split(" ", 2);
			String itemName;
			Optional<Item> itemOptional;

			try {
				switch(splitInput[0]){

					case "go":
						Room room = goToNextRoom(currentRoom, splitInput[1]);
						if(room.equals(currentRoom) || room == null){
							output = "The selected room does not exist. You still are in " + currentRoom.getName() + ".";
						}
						else{
							currentRoom = room;
							output = "You have just stepped into " + currentRoom.toString();
							if(currentRoom.isExit()){
								output = "Congratulations, you've found the exit!";
								gameEnded = true;
							}
						}
						break;
					case "look":
						output = currentRoom.toString();
						break;
					case "bag":
						output = player.getBag().toString();
						break;
					case "get":
						itemName = splitInput[1];
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
						itemName = splitInput[1];
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

	private Room goToNextRoom(Room currentRoom, String direction){
		Door requestedDoor = currentRoom.getDoors().get(direction);
		if(requestedDoor == null) {
			return currentRoom;
		}
		return requestedDoor.nextRoom(currentRoom);
	}
}
