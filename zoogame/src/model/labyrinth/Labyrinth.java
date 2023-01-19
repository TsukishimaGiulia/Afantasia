package model.labyrinth;

import bootstrap.Animals;
import exception.DirectionNotFoundException;
import model.animal.categories.Animal;
import model.item.Item;
import bootstrap.Items;
import utils.DirectionUtility;
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
        Random random = new Random();
        Room room = new Room("Entry room");
        rooms.add(room);

        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            int doorsLeft = random.nextInt(3) + 1 - r.getDoors().size();
            Room room1;

            if (doorsLeft == 0 && i < nRooms) {
                doorsLeft++;
            }

            for (int j = 0; j < doorsLeft; j++) {
                if (nRooms == rooms.size())
                    break;
                room1 = new Room("room " + rooms.size());
                Door door = new Door(true, r, room1);
                Direction direction = DirectionUtility.calculateFreeDirection(r.getDoors());
                r.getDoors().put(direction, door);
                try {
                    room1.getDoors().put(DirectionUtility.getOppositeDirection(direction), door);
                    rooms.add(room1);
                }catch(DirectionNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        rooms.get(rooms.size() - 1).setExit(true);
    }

    public void addAnimalsToLabyrinth() {
        Animals zoo = new Animals();
        Random random = new Random();
        int randomIndex;

        List<Animal> animals = zoo.getAllAnimals();
        int nAnimals = nRooms;

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

        int nItems = nRooms*2;
        for(int i = 1; i <= nItems; i++){
            randomIndex = random.nextInt(items.getItemList().size());
            Item selectedItem = items.getItemList().get(randomIndex);

            randomIndex = random.nextInt(nRooms);
            Room selectedRoom = rooms.get(randomIndex);

            selectedRoom.getItems().add(selectedItem);
            items.getItemList().remove(selectedItem);
        }
    }

    public void addAnimalsAndItemsToLabyrinth(){
        addAnimalsToLabyrinth();
        addItemsToLabyrinth();
    }
}
