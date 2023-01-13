package utility;

import exception.DirectionNotFoundException;
import model.item.Item;
import model.labyrinth.Direction;
import model.labyrinth.Door;

import java.util.*;

public class Utils {

    private Utils(){

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

    public static String itemsToString(List<Item> items) {
        String output = "";
        Map<String, Integer> itemsOccurrences = new HashMap<>();

        items.stream().forEach(i -> {
            if (itemsOccurrences.get(i.getName()) != null) {
                Integer x = itemsOccurrences.get((i.getName()));
                x++;
                itemsOccurrences.put(i.getName(), x);
            }else {
                itemsOccurrences.put(i.getName(),1);
            }
        });

        for (String key : itemsOccurrences.keySet()) {
            output += "- " + key.toString() + " x" + itemsOccurrences.get(key) + "\n";
        }

        return output;
    }
}
