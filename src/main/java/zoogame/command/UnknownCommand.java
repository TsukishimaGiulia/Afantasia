package command;

import game.GameController;

public class UnknownCommand extends Command {

    public UnknownCommand(GameController gc) {
        super(gc);
    }

    @Override
    public String execute(){
        return "Command not found";
    }
}
