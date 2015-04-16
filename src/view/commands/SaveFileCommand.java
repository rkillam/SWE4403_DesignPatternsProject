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
        if(this.backendFacade.isDocumentValid()) {
            try {
                File saveLocation = this.getSaveFile();
                if(saveLocation != null) {
                    FileWriter fileWriter = new FileWriter(saveLocation);
                    fileWriter.write(this.backendFacade.getDocumentModel().getDocumentString());
                    fileWriter.close();

                    this.backendFacade.setSaveFile(saveLocation);

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
        else {
            logger.log(
                    this.getClass(),
                    "Could not save document: Invalid HTML",
                    Logger.ERROR
            );
        }
    }
}
