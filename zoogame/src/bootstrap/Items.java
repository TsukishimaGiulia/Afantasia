package bootstrap;

import model.item.Item;

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
        items.add(new Item("apple", "restores 10 lp", 3));
        items.add(new Item("banana", "restores 15 lp", 4));
        items.add(new Item("poisoned apple", "takes off 10 lp", 2));
        items.add(new Item("cosa", "it's only a thing", 2));
        items.add(new Item("eagle plume", "keep it safe, maybe somebody's looking for it", 5));
        items.add(new Item("poisoned apple", "takes off 10 lp", 2));
        items.add(new Item("bottle of water", "restores 5 lp", 3));
        items.add(new Item("pen", "throw it away you don't need", 1));
        items.add(new Item("shoes", "keep it safe, maybe somebody's looking for it", 1));
        items.add(new Item("stopper", "throw it away you don't need", 1));
        items.add(new Item("bottle of wine", "attention, you may get lost after drinking it", 2));
        items.add(new Item("pizza", "restores 10 lp", 3));
        items.add(new Item("steak", "restores 10 lp", 3));
        items.add(new Item("gem", "keep it carefully, you may need it", 5));
        items.add(new Item("mushroom", "restores 2 lp", 2));
        items.add(new Item("poisonous mushroom", "takes off 3 lp", 2));
        items.add(new Item("flower", "not helpful, but it's nice", 1));
        items.add(new Item("rope", "you may need it", 2));
        items.add(new Item("leaf", "you may need it", 2));
        items.add(new Item("sceptre", "keep it carefully, you may need it", 5));
        items.add(new Item("hat", "not helpful, but it's nice", 1));
        items.add(new Item("book", "you may need it", 3));
        items.add(new Item("magic lamp", "keep it safe, maybe somebody's looking for it", 5));
        items.add(new Item("broom", "throw it away you don't need", 1));
        items.add(new Item("potion", "restores 10 lp", 3));
        items.add(new Item("wand", "you may need it", 2));
        items.add(new Item("cursed ring", "takes off 15 lp", 3));
        items.add(new Item("emerald necklace", "takes off 10 lp", 2));
        items.add(new Item("shield", "keep it carefully, you may need it", 5));
    }
}
