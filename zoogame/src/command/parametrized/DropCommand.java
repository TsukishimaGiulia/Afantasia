package command.parametrized;

import command.Command;
import exception.MissingParameterException;
import game.GameController;
import model.item.Item;

import java.util.Optional;

public class DropCommand extends ParametrizedCommand {

    public DropCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc, command);
    }
    @Override
    public String execute(){

        String output;
        String itemName = command[1];

        Item itemFromBag = gc.getPlayer().removeItemFromBag(itemName);
        if (itemFromBag!=null) {
            gc.getCurrentRoom().addItem(itemFromBag);
            output = "You have dropped " + itemName + ".";
        } else {
            output = "There isn't any " + itemName + " in your bag.";
        }

        return output;
    }
}
