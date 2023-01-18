package command.parametrized;

import command.Command;
import exception.ItemNotFoundException;
import exception.MissingParameterException;
import game.GameController;
import model.item.Item;

import java.util.Optional;

public class DropCommand extends ParametrizedCommand {

    public DropCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc, command);
    }
    @Override
    public String execute() throws ItemNotFoundException {
        String itemName = command[1];
        Item itemFromBag = gc.getPlayer().removeItemFromBag(itemName);
        gc.getCurrentRoom().addItem(itemFromBag);
        return "You have dropped " + itemName + ".";
    }
}
