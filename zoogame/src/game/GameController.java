package game;

import command.Command;
import command.CommandFactory;
import game.console.InputController;
import model.game.Bag;
import model.item.Item;
import model.game.Player;
import model.labyrinth.Direction;
import model.labyrinth.Door;
import model.labyrinth.Labyrinth;
import model.labyrinth.Room;

import java.util.*;

public class GameController {

	private Player player;

	private Room currentRoom;

	private boolean gameEnded = false;

	private static GameController instance;

	private GameController(){}

	public static GameController getInstance(){
		if(instance == null){
			instance = new GameController();
		}
		return instance;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}

	public void runGame() {
		try {
				String input;
				int labyrinthDimension = 0;
				Labyrinth labyrinth;

				System.out.println("Please enter your name");
				System.out.print(">");
				input = InputController.readString();
				player = new Player(input,100, new Bag());
				System.out.println("Hello " + player.getName() + "! Welcome to Afantasia, our fantastic world without fantasy!\n" +
						"In this game, you're lost in a labyrinth and you have to find the exit.\n" +
						"In your path you will find animals and objects to collect.\n");

				while (labyrinthDimension > 100 || labyrinthDimension < 5) {
					System.out.println("Please insert a number between 5 and 100 to define the dimension of the labyrinth: ");
					System.out.print(">");
					input = InputController.readString();
					try {
						labyrinthDimension = Integer.parseInt(input);
					} catch (NumberFormatException e) {
						System.err.println("You must type a number!!!!!"); //TO DO: check why it isn't always printed at the same point
					}
				}
			;

			labyrinth = new Labyrinth(14); //nRooms is constant because we don't have enough animals and items
			labyrinth.addAnimalsAndItemsToLabyrinth();
			currentRoom = labyrinth.getRooms().get(0);
			System.out.println("Congratulations, a labyrinth with " + labyrinth.getRooms().size() + " rooms has been created ;-) . Who do you think you are to take such a decision!?\n" +
					"You are now in the entry room. You can type your commands using the keyboard: write help for a list of possible commands.\n\n" +
					currentRoom.description() + "\n");

			while (!gameEnded) {
				String output = "";
				System.out.print(">");
				input = InputController.readString();
				String[] splitInput = input.toLowerCase().split(" ", 2);
				String itemName;
				Optional<Item> itemOptional;
				try {
					Command command = CommandFactory.make(splitInput, instance);
					output = command.execute();
				} catch (Exception e) {
					output = e.getMessage();
				}
				System.out.println(output + "\n");
			}
			}catch(Exception e){
				e.getMessage();
			}
		}

	public Room goToNextRoom(Room currentRoom, String direction){

		Door requestedDoor = currentRoom.getDoors().get(Direction.valueOf(direction.toUpperCase()));
		if(requestedDoor == null) {
			return currentRoom;
		}
		return requestedDoor.nextRoom(currentRoom);
	}
}
