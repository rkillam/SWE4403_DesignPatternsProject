package view.commands;

import controller.BackendFacade;
import util.Logger;
import view.windows.Window;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public abstract class SaveFileCommand extends Command {
    protected Window window;
    public SaveFileCommand(Window window, BackendFacade backendFacade) {
        super(backendFacade);
        this.window = window;
    }

    protected abstract File getSaveFile() throws IOException;

    @Override
    public void execute() {
        logger.log(this.getClass(), "In SaveFileCommand", Logger.DEBUG);

        try {
            File saveLocation = this.getSaveFile();
            logger.log(this.getClass(), "Got file", Logger.DEBUG);
            if(saveLocation != null) {
                logger.log(this.getClass(), "About to save file", Logger.DEBUG);
                FileWriter fileWriter = new FileWriter(saveLocation);
                logger.log(this.getClass(), "Made fileWriter", Logger.DEBUG);
                fileWriter.write(this.backendFacade.getDocumentModel().toString());
                logger.log(this.getClass(), "fileWriter.write", Logger.DEBUG);
                fileWriter.close();

                logger.log(this.getClass(), "File saved successfully!");
            }
            else {
                logger.log(this.getClass(), "Unable to save file", Logger.WARNING);
            }
        }
        catch(IOException e) {
            logger.log(
                    this.getClass(),
                    "IOException occurred while saving file: " + e.getMessage(),
                    Logger.ERROR
            );
        }
    }
}
