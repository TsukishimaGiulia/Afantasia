package utility;

import model.item.Item;
import model.labyrinth.Direction;
import model.labyrinth.Door;

import java.util.*;

public class Utils {

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
