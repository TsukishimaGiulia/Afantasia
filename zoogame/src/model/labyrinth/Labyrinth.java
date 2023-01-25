package model.labyrinth;

import bootstrap.AnimalService;
import exception.DirectionNotFoundException;
import lombok.Getter;
import model.animal.categories.Animal;
import model.item.Item;
import bootstrap.ItemService;
import utils.DirectionUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {

    private int nRooms;
    @Getter
    private List<Room> rooms;

    public Labyrinth(int nRooms) {
        this.nRooms = nRooms;
        this.rooms = new ArrayList<>(nRooms);
        generateLabyrinth(nRooms);
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
                Direction direction = DirectionUtil.calculateFreeDirection(r.getDoors());
                r.getDoors().put(direction, door);
                try {
                    room1.getDoors().put(DirectionUtil.getOppositeDirection(direction), door);
                    rooms.add(room1);
                }catch(DirectionNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        rooms.get(rooms.size() - 1).setExit(true);
    }

    public void addAnimalsToLabyrinth() {
        AnimalService zoo = new AnimalService();
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
        ItemService items = new ItemService();
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
