package command.parametrized;

import command.Command;
import exception.MissingParameterException;
import game.GameController;
import model.item.Item;

import java.util.Optional;

public class GetCommand extends ParametrizedCommand {

    public GetCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc, command);
    }

    @Override
    public String execute() {
        String output;
        String itemName = command[1];
        Item itemFromRoom = gc.getCurrentRoom().removeItem(itemName);

        if (itemFromRoom != null && gc.getPlayer().addItemToBag(itemFromRoom)) {
            output = "You have put " + itemName + " into your bag.";
        } else {
            output = "There isn't any " + itemName + " in this room.";
            gc.getCurrentRoom().addItem(itemFromRoom);
        }
        return output;
    }
}
