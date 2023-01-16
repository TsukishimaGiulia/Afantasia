package utils;

import exception.DirectionNotFoundException;
import model.labyrinth.Direction;
import model.labyrinth.Door;

import java.util.*;

public class DirectionUtility {

    private DirectionUtility(){

    }

    public static Direction calculateFreeDirection(Map<Direction, Door> doors){
        List<Direction> directions = new ArrayList<>();
        for(Direction d : Direction.values()){
            directions.add(d);
        }
        directions.removeAll(doors.keySet());
        return directions.get(new Random().nextInt(directions.size()));
    }

    public static Direction getOppositeDirection(Direction direction) throws DirectionNotFoundException {
        switch(direction){
            case NORTH:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.NORTH;
            case WEST:
                return Direction.EAST;
            case EAST:
                return Direction.WEST;
            default:
                throw new DirectionNotFoundException("direction not managed");
        }
    }
}
