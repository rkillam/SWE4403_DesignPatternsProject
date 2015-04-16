package view.commands;

import controller.BackendFacade;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class ShowHTMLTagsCommand extends Command {
    public ShowHTMLTagsCommand(BackendFacade backendFacade) {
        super(backendFacade);
    }

    @Override
    public void execute() {
        super.execute();
        logger.log(this.getClass(), "Executing Show HTML Tags Command");
    }
}
