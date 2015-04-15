package view.commands;

import backend.BackendFacade;
import util.Logger;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public abstract class Command {
    protected static Logger logger = Logger.getInstance();
    private BackendFacade backendFacade;

    public Command(BackendFacade backendFacade) {
        this.backendFacade = backendFacade;
    }

    public abstract void execute();
}
