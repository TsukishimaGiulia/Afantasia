package game;

import command.Command;
import command.CommandFactory;
import game.console.InputController;
import model.game.Bag;
import model.game.Player;
import model.labyrinth.Labyrinth;
import model.labyrinth.Room;

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
		String input;
		registerPlayer();
		System.out.println("Welcome to Afantasia, our fantastic world without fantasy!\n" +
				"In this game, you're lost in a labyrinth and you have to find the exit.\n" +
				"In your path you will find animals and objects to collect.\n");
		Labyrinth labyrinth = addLabyrinthToGame(chooseLabirinthDimension());
		System.out.println("You are now in the entry room. You can type your commands using the keyboard: write help for a list of possible commands.\n\n" +
				currentRoom.description() + "\n");

		while (!gameEnded) {
			String output = "";
			System.out.print(">");
			input = InputController.readString();
			String[] splitInput = input.toLowerCase().split(" ", 2);
			try {
				Command command = CommandFactory.make(splitInput, instance);
				output = command.execute();
			} catch (Exception e) {
				output = e.getMessage();
			}

			System.out.println(output + "\n");
		}
	}

	private void registerPlayer(){
		String input;
		System.out.println("Please enter your name");
		System.out.print(">");
		input = InputController.readString();
		player = new Player(input,100, new Bag());
		System.out.println("Hello " + player.getName() + "!");
	}

	private int chooseLabirinthDimension(){
		String input;
		int labyrinthDimension = 0;
		while (labyrinthDimension > 14 || labyrinthDimension < 5) { //max labyrinthDimension is 14 because we don't have enough animals and items for bigger dimensions
			System.out.println("Please insert a number between 5 and 100 to define the dimension of the labyrinth: ");
			System.out.print(">");
			input = InputController.readString();
			try {
				labyrinthDimension = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.err.println("You must type a number!!!!!");
			}
		}
		return labyrinthDimension;
	}

	private Labyrinth addLabyrinthToGame(int labyrinthDimesion){
		Labyrinth labyrinth = new Labyrinth(labyrinthDimesion);
		labyrinth.addAnimalsAndItemsToLabyrinth();
		currentRoom = labyrinth.getRooms().get(0);
		System.out.println("This labyrinth has " + labyrinth.getRooms().size() + " rooms.\n");
		return labyrinth;
	}
}
