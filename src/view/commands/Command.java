package view.commands;

import controller.BackendFacade;
import util.Logger;

import java.util.Observable;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class Command extends Observable {
    protected static final Logger logger = Logger.getInstance();
    protected BackendFacade backendFacade;

    public Command(BackendFacade backendFacade) {
        this.backendFacade = backendFacade;
        this.addObserver(this.backendFacade);
    }

    public void execute() {
        this.setChanged();
        this.notifyObservers();
    }
}
