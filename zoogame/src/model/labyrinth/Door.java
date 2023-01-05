package model.labyrinth;

public class Door {

    private boolean open;
    private Room presentRoom;
    private Room arrivingRoom;

    public Door(boolean open, Room presentRoom, Room arrivingRoom) {
        this.open = open;
        this.presentRoom = presentRoom;
        this.arrivingRoom = arrivingRoom;
    }

    public boolean isOpen() {
        return open;
    }

    public Room getPresentRoom() {
        return presentRoom;
    }

    public Room getArrivingRoom() {
        return arrivingRoom;
    }

    public Room nextRoom(Room currentRoom){
        if(currentRoom.equals(presentRoom)){
            return arrivingRoom;
        } else if (currentRoom.equals(arrivingRoom)) {
            return presentRoom;
        } else {
            return null;
        }
    }
}
