package model.labyrinth;

public class Door {

    private boolean open;
    private Room roomA;
    private Room roomB;

    public Door(boolean open, Room roomA, Room roomB) {
        this.open = open;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public boolean isOpen() {
        return open;
    }

    public Room getRoomA() {
        return roomA;
    }

    public Room getRoomB() {
        return roomB;
    }

    public Room nextRoom(Room currentRoom){
        if(currentRoom.equals(roomA)){
            return roomB;
        } else if (currentRoom.equals(roomB)) {
            return roomA;
        } else {
            return null;
        }
    }
}
