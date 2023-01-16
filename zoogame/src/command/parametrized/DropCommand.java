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
        Optional<Item> itemOptional = gc.getPlayer().getBag().getItems().stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst();
            if (itemOptional.isPresent()) {
                gc.getPlayer().getBag().removeItem(itemOptional.get());
                gc.getCurrentRoom().addItem(itemOptional.get());
                output = "You have dropped " + itemName + ".";
            } else {
                output = "There isn't any " + itemName + " in your bag.";
            }

        return output;
    }
}
