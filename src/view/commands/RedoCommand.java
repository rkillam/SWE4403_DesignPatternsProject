package view.commands;

import controller.BackendFacade;
import util.Logger;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class RedoCommand extends Command {
    public RedoCommand(BackendFacade backendFacade) {
        super(backendFacade);
    }

    @Override
    public void execute() {
        this.backendFacade.redo();
        logger.log(this.getClass(), "Redo command", Logger.DEBUG);
    }
}
