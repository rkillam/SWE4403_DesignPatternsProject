package view.commands;

import backend.BackendFacade;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class HideHTMLTagsCommand extends Command {
    public HideHTMLTagsCommand(BackendFacade backendFacade) {
        super(backendFacade);
    }

    @Override
    public void execute() {
        logger.log(this.getClass(), "Executing Hide HTML Tags Command");
    }
}
