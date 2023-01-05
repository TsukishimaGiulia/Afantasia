package model.labyrinth;

public enum Direction {

    NORTH,
    SOUTH,
    WEST,
    EAST;

//    NORTH_WEST,
//    SOUTH_EAST;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
