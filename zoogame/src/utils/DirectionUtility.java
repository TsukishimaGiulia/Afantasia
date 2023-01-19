package utils;

import exception.DirectionNotFoundException;
import model.labyrinth.Direction;
import model.labyrinth.Door;

import java.util.*;
import java.util.stream.Collectors;

public class DirectionUtility {

    private DirectionUtility(){

    }

    public static Direction calculateFreeDirection(Map<Direction, Door> doors){
        Random random = new Random();
        List<Direction> directions = Arrays.stream(Direction.values())
                .filter(direction -> !direction.equals(doors.keySet()))
                .collect(Collectors.toList());
        return directions.get(random.nextInt(directions.size()));
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
