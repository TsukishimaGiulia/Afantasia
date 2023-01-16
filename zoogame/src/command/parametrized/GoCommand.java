package command.parametrized;

import command.Command;
import exception.MissingParameterException;
import game.GameController;
import model.labyrinth.Room;

public class GoCommand extends ParametrizedCommand {


    public GoCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc, command);
    }
    @Override
    public String execute(){
        String output = "";
        Room room = gc.goToNextRoom(gc.getCurrentRoom(), command[1]);
        if (room.equals(gc.getCurrentRoom()) || room == null) {
            output = "The selected room does not exist. You still are in " + gc.getCurrentRoom().getName() + ".";
        } else {
            gc.setCurrentRoom(room);
            output = "You have just stepped into " + gc.getCurrentRoom().description();
            if (gc.getCurrentRoom().isExit()) {
                output = "Congratulations, " + gc.getPlayer().getName() + ", you've found the exit!";
                gc.setGameEnded(true);
            }
        }
        return output;
    }
}
