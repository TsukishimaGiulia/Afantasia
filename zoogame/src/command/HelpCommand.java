package command;

import game.GameController;

public class HelpCommand extends Command {

    public HelpCommand(GameController gc) {
        super(gc);
    }

    @Override
    public String execute(){
        return "- go: lets you move through rooms, specifying the direction (north, south, east, west) as a parameter (ex: go north);\n" +
                "- look: gives you the description of the room, including items and animals present;\n" +
                "- bag: gives you the list of items in your bag;\n" +
                "- get: lets you pick up an item selected as a parameter from the room and put it in your bag (ex: get itemName);\n" +
                "- drop: lets you drop an item selected as a parameter from your bag and leave it in the current room (ex: drop itemName);\n" +
                "- exit: ends the game.";
    }


}
