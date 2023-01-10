package bootstrap;

import model.item.*;

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
        items.add(new HealthyItem("apple", "restores 10 lp", 3));
        items.add(new HealthyItem("apple", "restores 10 lp", 3));
        items.add(new HealthyItem("apple", "restores 10 lp", 3));
        items.add(new HealthyItem("banana", "restores 15 lp", 4));
        items.add(new HealthyItem("banana", "restores 15 lp", 4));
        items.add(new HealthyItem("banana", "restores 15 lp", 4));
        items.add(new HealthyItem("bottle of water", "restores 5 lp", 3));
        items.add(new HealthyItem("bottle of water", "restores 5 lp", 3));
        items.add(new HealthyItem("bottle of water", "restores 5 lp", 3));
        items.add(new HealthyItem("pizza", "restores 10 lp", 3));
        items.add(new HealthyItem("pizza", "restores 10 lp", 3));
        items.add(new HealthyItem("pizza", "restores 10 lp", 3));
        items.add(new HealthyItem("steak", "restores 10 lp", 3));
        items.add(new HealthyItem("steak", "restores 10 lp", 3));
        items.add(new HealthyItem("steak", "restores 10 lp", 3));
        items.add(new HealthyItem("mushroom", "restores 2 lp", 2));
        items.add(new HealthyItem("mushroom", "restores 2 lp", 2));
        items.add(new HealthyItem("mushroom", "restores 2 lp", 2));
        items.add(new HealthyItem("potion", "restores 10 lp", 3));
        items.add(new HealthyItem("potion", "restores 10 lp", 3));
        items.add(new HealthyItem("potion", "restores 10 lp", 3));

        items.add(new UselessItem("cosa", "it's only a thing", 2));
        items.add(new UselessItem("cosa", "it's only a thing", 2));
        items.add(new UselessItem("pen", "throw it away you don't need", 1));
        items.add(new UselessItem("pen", "throw it away you don't need", 1));
        items.add(new UselessItem("shoes", "throw it away you don't need", 1));
        items.add(new UselessItem("shoes", "throw it away you don't need", 1));
        items.add(new UselessItem("stopper", "throw it away you don't need", 1));
        items.add(new UselessItem("stopper", "throw it away you don't need", 1));
        items.add(new UselessItem("flower", "not helpful, but it's nice", 1));
        items.add(new UselessItem("flower", "not helpful, but it's nice", 1));
        items.add(new UselessItem("rope", "throw it away you don't need", 2));
        items.add(new UselessItem("rope", "throw it away you don't need", 2));
        items.add(new UselessItem("leaf", "throw it away you don't need", 2));
        items.add(new UselessItem("leaf", "throw it away you don't need", 2));
        items.add(new UselessItem("hat", "not helpful, but it's nice", 1));
        items.add(new UselessItem("hat", "not helpful, but it's nice", 1));
        items.add(new UselessItem("broom", "throw it away you don't need it", 1));
        items.add(new UselessItem("broom", "throw it away you don't need it", 1));

        items.add(new UnhealthyItem("poisoned apple", "takes off 10 lp", 2));
        items.add(new UnhealthyItem("poisoned apple", "takes off 10 lp", 2));
        items.add(new UnhealthyItem("poisoned apple", "takes off 10 lp", 2));
        items.add(new UnhealthyItem("bottle of wine", "attention, you may get lost after drinking it", 2));
        items.add(new UnhealthyItem("bottle of wine", "attention, you may get lost after drinking it", 2));
        items.add(new UnhealthyItem("bottle of wine", "attention, you may get lost after drinking it", 2));
        items.add(new UnhealthyItem("poisonous mushroom", "takes off 3 lp", 2));
        items.add(new UnhealthyItem("poisonous mushroom", "takes off 3 lp", 2));
        items.add(new UnhealthyItem("poisonous mushroom", "takes off 3 lp", 2));
        items.add(new UnhealthyItem("cursed ring", "takes off 15 lp", 3));
        items.add(new UnhealthyItem("cursed ring", "takes off 15 lp", 3));
        items.add(new UnhealthyItem("cursed ring", "takes off 15 lp", 3));
        items.add(new UnhealthyItem("cursed emerald", "takes off 10 lp", 2));
        items.add(new UnhealthyItem("cursed emerald", "takes off 10 lp", 2));
        items.add(new UnhealthyItem("cursed emerald", "takes off 10 lp", 2));

        items.add(new PreciousItem("eagle plume", "keep it safe, maybe somebody's looking for it", 5));
        items.add(new PreciousItem("gem", "keep it carefully, you may need it", 5));
        items.add(new PreciousItem("sceptre", "keep it carefully, you may need it", 5));
        items.add(new PreciousItem("book", "you may need it", 3));
        items.add(new PreciousItem("magic lamp", "keep it safe, maybe somebody's looking for it", 5));
        items.add(new PreciousItem("wand", "you may need it", 2));
        items.add(new PreciousItem("shield", "keep it carefully, you may need it", 5));
    }
}
