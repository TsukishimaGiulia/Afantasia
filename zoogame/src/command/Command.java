package command;

import game.GameController;
import model.labyrinth.Room;

public abstract class Command {

    protected GameController gc;

    protected Command(GameController gc) {
        this.gc = gc;
    }

    public abstract String execute();
}
