package command.parametrized;

import command.Command;
import exception.MissingParameterException;
import game.GameController;

public abstract class ParametrizedCommand extends Command {
    protected String[] command;

    protected ParametrizedCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc);
        if(command.length == 1 || command[1].trim().equals("")){
            throw new MissingParameterException("Missing parameter.");
        }
        this.command = command;
    }
}
