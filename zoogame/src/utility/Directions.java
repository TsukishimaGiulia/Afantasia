package utility;

import model.labyrinth.Direction;
import model.labyrinth.Door;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Directions {

    public static String calculateFreeDirection(Map<String, Door> doors){
        List<String> directions = new ArrayList<>();
        for(Direction d : Direction.values()){
            directions.add(d.toString());
        }
        directions.removeAll(doors.keySet());
        return directions.get(new Random().nextInt(directions.size()));
    }

    public static String getOppositeDirection(String direction){
        switch(direction.toLowerCase()){
            case "north":
                return "south";
            case "south":
                return "north";
            case "west":
                return "east";
            case "east":
                return "west";
           /* case "north west":
                return "south east";
            case "south east":
                return "north west";
            */
            default:
                throw new RuntimeException("direction not managed");
        }
    }
}
