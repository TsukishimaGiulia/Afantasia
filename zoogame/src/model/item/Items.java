package model.item;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private List<Item> items = new ArrayList<>();

    public Items() {
        initialize();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void initialize(){
        items.add(new Item("apple", "restores 10 lp", 2));
        items.add(new Item("banana", "restores 15 lp", 3));
        items.add(new Item("poisoned apple", "takes off 10 lp", 2));
        items.add(new Item("cosa", "una cosa", 2));
        items.add(new Item("eagle plume", "keep it safe, maybe somebody's looking for it", 2));
    }
}
