package view.commands;

import controller.BackendFacade;
import util.Logger;
import view.windows.Window;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class SaveAsCommand extends SaveCommand {
    public SaveAsCommand(Window window, BackendFacade backendFacade) {
        super(window, backendFacade);
    }

    protected File getSaveFile() throws IOException {
        logger.log(this.getClass(), "Saving new document.", Logger.INFO);

        File retFile = null;
        JFileChooser fileChooser = new JFileChooser();
        Integer returnValue = fileChooser.showSaveDialog(window);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            retFile = fileChooser.getSelectedFile();

            if(!retFile.exists()) {
                if(!retFile.createNewFile()) {
                    throw new IOException("Unable to create new file");
                }
            }
        }
        else {
            logger.log(this.getClass(), "Save As operation was cancelled", Logger.INFO);
        }

        return retFile;
    }

    @Override
    public void execute() {
        logger.log(this.getClass(), "Saving", Logger.DEBUG);
        super.execute();
        logger.log(this.getClass(), "Done Saving", Logger.DEBUG);
    }
}
