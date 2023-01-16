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
        Optional<Item> itemOptional = gc.getCurrentRoom().getItems().stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst();
            if (itemOptional.isPresent() && gc.getPlayer().getBag().addItem(itemOptional.get())) {
                gc.getCurrentRoom().removeItem(itemOptional.get());
                output = "You have put " + itemName + " into your bag.";
            } else {
                output = "There isn't any " + itemName + " in this room.";
            }

        return output;
    }
}
