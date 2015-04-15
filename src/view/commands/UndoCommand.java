package view.commands;

import backend.BackendFacade;
import util.Logger;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class UndoCommand implements Command {
    private static final Logger logger = Logger.getInstance();
    private BackendFacade backendFacade;

    public UndoCommand(BackendFacade backendFacade) {
        this.backendFacade = backendFacade;
    }

    @Override
    public void execute() {
        logger.log(this.getClass(), "Executing Undo Command");
    }
}
