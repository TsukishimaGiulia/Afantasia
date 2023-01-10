package model.item;

import model.game.Player;

public class PreciousItem extends Item{

    public PreciousItem(String name, String description, int requiredSlots) {
        super(name, description, requiredSlots);
    }

    @Override
    public String use(Player player) {
        //TO DO: implement this method
        return "It was useful!";
    }
}
