package command;

import game.GameController;

public class ExitCommand extends Command {

    public ExitCommand(GameController gc) {
        super(gc);
    }

    @Override
    public String execute() {
        gc.setGameEnded(true);
        return "Bye, " + gc.getPlayer().getName() + ". We hope to see you again! :-) ";
    }
}
