package command.parametrized;


import exception.FullBagException;
import exception.ItemNotFoundException;
import exception.MissingParameterException;
import game.GameController;
import model.item.Item;

public class GetCommand extends ParametrizedCommand {

    public GetCommand(GameController gc, String[] command) throws MissingParameterException {
        super(gc, command);
    }

    @Override
    public String execute() throws ItemNotFoundException {
        String itemName = command[1];
        Item itemFromRoom = gc.getCurrentRoom().removeItem(itemName);
        try {
            gc.getPlayer().addItemToBag(itemFromRoom);
            return "You have put " + itemName + " into your bag.";
        } catch (FullBagException e) {
            gc.getCurrentRoom().addItem(itemFromRoom);
            return e.getMessage();
        }
    }
}
