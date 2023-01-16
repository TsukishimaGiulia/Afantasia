package utils;

import model.item.Item;

import java.util.List;

public class Search {

    private Search(){}

    public static Item itemByName(String itemName, List<Item> items){
        return items.stream()
                .filter(i -> i.getName().equals(itemName))
                .findFirst()
                .orElse(null);
    }
}
