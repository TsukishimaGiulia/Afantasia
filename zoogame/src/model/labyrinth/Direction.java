package model.labyrinth;

public enum Direction {

    NORTH ("north"),
    SOUTH("south"),
    WEST("west"),
    EAST("east");

   private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
