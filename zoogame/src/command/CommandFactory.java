package command;

import command.parametrized.DropCommand;
import command.parametrized.GetCommand;
import command.parametrized.GoCommand;
import exception.MissingParameterException;
import game.GameController;

public class CommandFactory {

    public static Command make(String[] command, GameController gc) throws MissingParameterException {
        Command c = null;

        // go, look, bag, get, drop, help, exit

        switch(command[0]){
            case "go":
                c = new GoCommand(gc, command);
                break;
            case "look":
                c = new LookCommand(gc);
                break;
            case "bag":
                c = new BagCommand(gc);
                break;
            case "get":
                c = new GetCommand(gc, command);
                break;
            case "drop":
                c = new DropCommand(gc, command);
                break;
            case "help":
                c = new HelpCommand(gc);
                break;
            case "default":
                c = new UnknownCommand(gc);
                break;
        }
        return c;
    }
}
