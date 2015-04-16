package view.commands;

import controller.BackendFacade;
import util.Logger;
import view.windows.Window;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class SaveCommand extends SaveFileCommand {
    public SaveCommand(Window window, BackendFacade backendFacade) {
        super(window, backendFacade);
    }

    @Override
    protected File getSaveFile() throws IOException {
        File retFile = this.backendFacade.getSaveFile();
        if(retFile == null || !retFile.canWrite()) {
            retFile = new SaveAsCommand(this.window, this.backendFacade).getSaveFile();
        }

        return retFile;
    }

    @Override
    public void execute() {
        super.execute();
    }
}
