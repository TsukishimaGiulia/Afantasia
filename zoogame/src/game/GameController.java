package game;

import model.animal.Zoo;
import game.console.InputController;
import model.item.Item;
import model.game.Player;
import model.item.Items;
import model.labyrinth.Door;
import model.labyrinth.Labyrinth;
import model.labyrinth.Room;
import model.animal.categories.Animal;

import java.util.*;

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
							output = "You have just stepped into " + currentRoom.toString();
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

	// Prevediamo di utilizzare il seguente metodo solo dentro RunGame(), quindi lo mettiamo private
	private Room goToNextRoom(Room currentRoom, String direction){
		Door requestedDoor = currentRoom.getDoors().get(direction);
		if(requestedDoor == null) {
			return currentRoom;
		}
		Room requestedRoom = requestedDoor.nextRoom(currentRoom);
		return requestedRoom;
	}

	// Prevediamo di utilizzare il seguente metodo solo dentro RunGame(), quindi lo mettiamo private
	public Labyrinth generateLabyrinth(int nRooms){
//		double random = Math.random()*nRooms;
		Zoo zoo = new Zoo();
		Items items = new Items();
		Random random = new Random();
		int randomIndex;

		List<Room> rooms = new ArrayList<>(nRooms);

		// Questa lista conterrà alla posizione i-esima il numero di porte per la stanza alla posizione i-esima della lista rooms
		//List<Integer> nDoorForRoom = new ArrayList<>(nRooms);

		//CREAZIONE E COLLEGAMENTO DELLE STANZE
		Room room = new Room("Entry room");
		rooms.add(room);

		for(int i = 0; i<rooms.size(); i++){
			Room r = rooms.get(i);
			randomIndex = random.nextInt(3);
			//nDoorForRoom.add(randomIndex);
			int doorsLeft = randomIndex + 1 - r.getDoors().size();
			Room room1;

			if(doorsLeft==0 && i<nRooms){
				doorsLeft++;
			}

			for (int j = 0; j<doorsLeft; j++){
				if(nRooms == rooms.size())
					break;
				room1 = new Room("room " + rooms.size());
				Door door = new Door(true, r, room1 ); // Abbiamo associato alla porta le 2 stanze
				String direction = calculateDirection(r.getDoors()); //Estraiamo una direzione a caso fra quelle non occupate da port
				r.getDoors().put(direction, door); //Aggiungiamo la porta alla mappa di porte della prima stanza creata, in corrispondenza della direzione estratta
				room1.getDoors().put(getOppositeDirection(direction), door);//Aggiungiamo la porta alla mappa di porte della seconda stanza, in corrispondenza della direzione opposta alla prima
				rooms.add(room1);
			}
		}

		// DECIDIAMO QUANTI E QUALI ANIMALI ANDRANNO NEL GIOCO (DA DISTRIBUIRE NELLE STANZE)
		// Otteniamo l'intera lista di animali dello zoo
		List<Animal> animals = zoo.getAllAnimals();

		// Dimensioniamo la quantità di animali in base al numero delle stanze
		int nAnimals = nRooms/8;

		// Selezioniamo gli animali randomicamente e li inseriamo in stanze casuali
		for(int i = 1; i <= nAnimals; i++){
			randomIndex = random.nextInt(animals.size());
			Animal selectedAnimal = animals.get(randomIndex);

			randomIndex = random.nextInt(nRooms);
			Room selectedRoom = rooms.get(randomIndex);

			selectedRoom.getAnimals().add(selectedAnimal);
			animals.remove(selectedAnimal);
		}

		// DECIDIAMO QUANTI E QUALI OGGETTI ANDRANNO NEL GIOCO (DA DISTRIBUIRE NELLE STANZE)
		int nItems = nRooms/4;
		for(int i = 1; i <= nItems; i++){
			randomIndex = random.nextInt(items.getItems().size());
			Item selectedItem = items.getItems().get(randomIndex);

			randomIndex = random.nextInt(nRooms);
			Room selectedRoom = rooms.get(randomIndex);

			selectedRoom.getItems().add(selectedItem);
			items.getItems().remove(selectedItem);
		}

		for(Room r : rooms){
			System.out.println(r.toString());
		}
//		System.out.println(rooms);
		System.out.println("rooms size: "+rooms.size());
		return new Labyrinth(rooms);
	}

	private String calculateDirection(Map<String, Door> doors){
		List<String> directions = new ArrayList<>();
		directions.add("north");
		directions.add("south");
		directions.add("west");
		directions.add("east");
		directions.removeAll(doors.keySet());
		return directions.get(new Random().nextInt(directions.size()));
	}

	private String getOppositeDirection(String direction){
		switch(direction){
			case "north":
				return "south";
			case "south":
				return "north";
			case "west":
				return "east";
			case "east":
				return "west";
			default:
				throw new RuntimeException("direction not managed");
		}
	}
}
