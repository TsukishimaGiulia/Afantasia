package model.labyrinth;

import model.animal.Zoo;
import model.animal.categories.Animal;
import model.item.Item;
import model.item.Items;
import utility.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {

    private int nRooms;
    private List<Room> rooms;

    public Labyrinth(int nRooms) {
        this.nRooms = nRooms;
        this.rooms = new ArrayList<>(nRooms);
        generateLabyrinth(nRooms);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    private void generateLabyrinth(int nRooms) {
//		double random = Math.random()*nRooms;

        Room room = new Room("Entry room");
        rooms.add(room);

        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            int doorsLeft = new Random().nextInt(3) + 1 - r.getDoors().size();
            Room room1;

            if (doorsLeft == 0 && i < nRooms) {
                doorsLeft++;
            }

            for (int j = 0; j < doorsLeft; j++) {
                if (nRooms == rooms.size())
                    break;
                room1 = new Room("room " + rooms.size());
                Door door = new Door(true, r, room1);
                String direction = Utils.calculateFreeDirection(r.getDoors());
                r.getDoors().put(direction, door);
                room1.getDoors().put(Utils.getOppositeDirection(direction), door);
                rooms.add(room1);
            }
        }
        rooms.get(rooms.size() - 1).setExit(true);
    }

    public void addAnimalsToLabyrinth() {
        Zoo zoo = new Zoo();
        Random random = new Random();
        int randomIndex;

        List<Animal> animals = zoo.getAllAnimals();
        int nAnimals = nRooms / 3;

        for (int i = 1; i <= nAnimals; i++) {
            randomIndex = random.nextInt(animals.size());
            Animal selectedAnimal = animals.get(randomIndex);

            randomIndex = random.nextInt(nRooms);
            Room selectedRoom = rooms.get(randomIndex);

            selectedRoom.getAnimals().add(selectedAnimal);
            animals.remove(selectedAnimal);
        }
    }

    public void addItemsToLabyrinth(){
        Items items = new Items();
        Random random = new Random();
        int randomIndex;

        int nItems = nRooms/3;
        for(int i = 1; i <= nItems; i++){
            randomIndex = random.nextInt(items.getItems().size());
            Item selectedItem = items.getItems().get(randomIndex);

            randomIndex = random.nextInt(nRooms);
            Room selectedRoom = rooms.get(randomIndex);

            selectedRoom.getItems().add(selectedItem);
            items.getItems().remove(selectedItem);
        }
    }

    public void addAnimalsAndItemsToLabyrinth(){
        addAnimalsToLabyrinth();
        addItemsToLabyrinth();
    }
}
