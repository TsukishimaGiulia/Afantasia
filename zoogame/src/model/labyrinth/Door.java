package model.labyrinth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Door {

    private boolean open;
    private Room roomA;
    private Room roomB;


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
