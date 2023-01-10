package model.item;

import model.game.Player;

public class UselessItem extends Item{

    public UselessItem(String name, String description, int requiredSlots) {
        super(name, description, requiredSlots);
    }

    @Override
    public String use(Player player) {
        //TO DO: implement this method
        return "Nothing happened.";
    }
}
