package model.labyrinth;

import java.util.List;

public class Labyrinth {
    private List<Room> rooms;
    // Contiene solo una lista di stanze, in quanto le stanze già contengono porte, animali e cose

    public Labyrinth(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
