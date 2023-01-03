package model.labyrinth;

public class Door {
    private boolean open;

    private Room presentRoom;

    private Room arrivingRoom;

    // La porta collega sempre e comunque due stanze: infatti, se in futuro volessimo aggiungere dei corridoi, il corridoio sarà comunque una (figlia di) stanza e le due stanze collegate saranno la stanza di partenza (1) e il corridoio (2).
    // Come potremmo impostare una dimensione fissa = 2?


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
