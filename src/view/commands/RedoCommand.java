package view.commands;

import controller.BackendFacade;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class RedoCommand extends Command {
    public RedoCommand(BackendFacade backendFacade) {
        super(backendFacade);
    }

    @Override
    public void execute() {
        super.execute();
        logger.log(this.getClass(), "Executing Redo Command");
    }
}
