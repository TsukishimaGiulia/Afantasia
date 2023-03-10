package utils;

import model.animal.categories.Animal;
import model.item.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stringify {

    private Stringify(){

    }

    private static String notEmptyListOfItems(List<Item> items) {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> itemsOccurrences = new HashMap<>();

        items.stream().forEach(i -> {
            if (itemsOccurrences.get(i.getName()) != null) {
                int x = itemsOccurrences.get((i.getName()));
                x++;
                itemsOccurrences.put(i.getName(), x);
            }else {
                itemsOccurrences.put(i.getName(),1);
            }
        });

        for (String key : itemsOccurrences.keySet()) {
            builder.append("\n- " + key + " x" + itemsOccurrences.get(key) + "");
        }

        return builder.toString();
    }

    public static String listOfItems(List<Item> items){
        return (items == null || items.isEmpty() ?
                "There are no items." :
                notEmptyListOfItems(items));
    }

    public static String listOfAnimals(List<Animal> animals){
        return (animals == null || animals.isEmpty() ?
                "There are no animals" :
                animals.stream()
                        .map(a -> a.simpleDescription())
                        .reduce("", (s1,s2)-> s1 + "\n- " + s2));
    }
}
