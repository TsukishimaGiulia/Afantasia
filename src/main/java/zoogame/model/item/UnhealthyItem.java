package model.item;

import model.game.Player;

public class UnhealthyItem extends Item{

    private int takenOffLp;

    public UnhealthyItem(String name, String description, int requiredSlots) {
        super(name, description, requiredSlots);
    }

    public UnhealthyItem(String name, String description, int requiredSlots, int takenOffLp) {
        super(name, description, requiredSlots);
        this.takenOffLp = takenOffLp;
    }

    @Override
    public String use(Player player) {
        //TO DO: implement this method
        return takenOffLp + " lp have been taken off.";
    }
}
