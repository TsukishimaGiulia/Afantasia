package command;

import game.GameController;

public class BagCommand extends Command {

    protected BagCommand(GameController gc) {
        super(gc);
    }

    @Override
    public String execute(){
        return gc.getPlayer().getBag().toString();
    }
}
