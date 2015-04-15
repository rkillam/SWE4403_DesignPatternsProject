package view.commands;

import backend.BackendFacade;
import util.Logger;
import view.windows.Window;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class SaveCommand implements Command {
    private static final Logger logger = Logger.getInstance();
    private Window window;
    private BackendFacade backendFacade;

    public SaveCommand(Window window, BackendFacade backendFacade) {
        this.window = window;
        this.backendFacade = backendFacade;
    }

    @Override
    public void execute() {
        String document = "";
        File saveLocation = new File("testing.txt");  //this.backendFacade.getFileSaveLocation();

//        try {
//            document = this.backendFacade.getDocument();
//        }
//        catch(HtmlTagMismatchException e) {
//            logger.log(this.getClass(), "Unable to save file because the HTML was not well formed: " + e.getMessage());
//            JOptionPane.showMessageDialog(window, "Cannot save file: The HTML is not well formed.");
//            return;
//        }
//        catch(DocumentEditException e) {
//            logger.log(this.getClass(), "Unable to save file because the text was changed: " + e.getMessage());
//            JOptionPane.showMessageDialog(window, "Cannot save file: Only HTML tags can be edited, not regular text.");
//            return;
//        }

        if(saveLocation == null || !saveLocation.canWrite()) {
            Command saveAs = new SaveAsCommand(this.window, this.backendFacade);
            saveAs.execute();
        }
        else {
            try {
                FileWriter fileWriter = new FileWriter(saveLocation);
                fileWriter.write(document);
                fileWriter.close();
                logger.log(this.getClass(), "File saved successfully!");
            }
            catch(IOException e) {
                logger.log(this.getClass(), "IOException occurred while saving file: " + e.getMessage());
            }
        }
    }
}
