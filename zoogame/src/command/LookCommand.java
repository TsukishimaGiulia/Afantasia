package command;

import game.GameController;
import model.labyrinth.Room;

public class LookCommand extends Command {

    protected LookCommand(GameController gc) {
        super(gc);
    }

    @Override
    public String execute(){
        return gc.getCurrentRoom().description();
    }
}
