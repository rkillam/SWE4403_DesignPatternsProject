package view.commands;

import controller.BackendFacade;
import util.Logger;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class UndoCommand extends Command {
    public UndoCommand(BackendFacade backendFacade) {
        super(backendFacade);
    }

    @Override
    public void execute() {
        this.backendFacade.undo();
        logger.log(this.getClass(), "Undo command", Logger.DEBUG);
    }
}
