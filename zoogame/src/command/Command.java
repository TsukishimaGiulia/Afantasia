package command;

import exception.ItemNotFoundException;
import game.GameController;

public abstract class Command {

    protected GameController gc;

    protected Command(GameController gc) {
        this.gc = gc;
    }

    public abstract String execute() throws ItemNotFoundException;
}
