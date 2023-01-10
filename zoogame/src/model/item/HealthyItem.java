package model.item;

import model.game.Player;

public class HealthyItem extends Item{

    private int restoredLp;

    public HealthyItem(String name, String description, int requiredSlots) {
        super(name, description, requiredSlots);
    }

    @Override
    public String use(Player player) {
        //TO DO: implement this method
        return restoredLp + " lp have been restored.";
    }

    public HealthyItem(String name, String description, int requiredSlots, int restoredLp) {
        super(name, description, requiredSlots);
        this.restoredLp = restoredLp;
    }
}
