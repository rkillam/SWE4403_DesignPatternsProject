package view.commands;

import backend.BackendFacade;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class SaveAsCommand extends Command {
    public SaveAsCommand(BackendFacade backendFacade) {
        super(backendFacade);
    }

    @Override
    public void execute() {
        logger.log(this.getClass(), "Executing Save As Command");
    }
}
