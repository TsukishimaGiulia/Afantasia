package command.parametrized;

import exception.MissingParameterException;
import game.GameController;
import model.labyrinth.Room;

public class GoCommand extends ParametrizedCommand {

    public GoCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc, command);
    }

    @Override
    public String execute(){
        Room room = gc.getCurrentRoom().goToNextRoom(command[1]);
        if (room.equals(gc.getCurrentRoom())) {
            return "The selected room does not exist. You still are in " + gc.getCurrentRoom().getName() + ".";
        } else {
            gc.setCurrentRoom(room);
            if (gc.getCurrentRoom().isExit()) {
                gc.setGameEnded(true);
                return "Congratulations, " + gc.getPlayer().getName() + ", you've found the exit!";
            }
            return "You have just stepped into " + gc.getCurrentRoom().description();
        }
    }
}
