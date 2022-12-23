package game;

import game.console.InputController;
import game.model.Player;
import map.model.Room;

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

		String welcome = "Welcome to Afantasia, our fantastic world without fantasy!\nYou are now in the entry room and you have to find the exit.\nIn your path you will find animals that can give you suggestions on what to do, and objects to collect.\nYou can type your commands using the keyboard: write help for a list of possible comamnds.";

		while(!gameEnded) {
			String output = "";
			String input;
//			System.out.println("Where are you going to go?");
			System.out.println(welcome);
			System.out.print(">");
			input = InputController.readString();
			switch(input.toLowerCase().split(" ")[0]){
				case "go": 	Room room = goToNextRoom(currentRoom, input.toLowerCase().split(" ")[1]);
							if(room.equals(currentRoom) || room == null){
								output = "The selected room does not exist. You still are in " + currentRoom.getName();
							}
							else{
								currentRoom = room;
								output = "You just stepped into " + currentRoom.toString();
							}
					break;
				case "look": currentRoom.toString();
					break;
				case "bag":
					break;
				case "get":
					break;
				case "drop":
					break;
				case "help":	// elenca i possibili comandi
					break;
				case "exit":
					gameEnded = true;
					break;
				default:
					output = "Command not valid";
					break;
			}

			/*
			* Inserire qui la gestione degli altri comandi
			*/


//			if (input.equals("exit")) {
//				gameEnded = true;
//			}
			System.out.println(output);
		}
	}

	// prevediamo di utilizzare il seguente metodo solo dentro RunGame(), quindi lo mettiamo private
	private Room goToNextRoom(Room currentRoom, String direction){
		Room requestedRoom = currentRoom.getAdjoiningRooms().get(direction);
		if(requestedRoom==null) {
			return currentRoom;
		}
		return requestedRoom;
	}
}
