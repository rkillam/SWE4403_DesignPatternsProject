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
public class SaveAsCommand implements Command {
    private static final Logger logger = Logger.getInstance();
    private Window window;
    private BackendFacade backendFacade;

    public SaveAsCommand(Window window, BackendFacade backendFacade) {
        this.window = window;
        this.backendFacade = backendFacade;
    }

    @Override
    public void execute() {
        logger.log(this.getClass(), "Saving new document.");
        JFileChooser fileChooser = new JFileChooser();
        Integer returnValue = fileChooser.showSaveDialog(window);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File saveToFile = fileChooser.getSelectedFile();

                if(!saveToFile.exists()) {
                    Boolean created = saveToFile.createNewFile();

                    if(created) {
                        String document;

//                        try {
//                            document = facade.getDocument();
//                        }
//                        catch(HtmlTagMismatchException e) {
//                            logger.log(SaveFileCommand.class, "Unable to save file because the HTML was not well formed: " + e.getMessage());
//                            JOptionPane.showMessageDialog(window, "Cannot save file: The HTML is not well formed.");
//                            return;
//                        }
//                        catch(DocumentEditException e) {
//                            logger.log(SaveFileCommand.class, "Unable to save file because the text was changed: " + e.getMessage());
//                            JOptionPane.showMessageDialog(window, "Cannot save file: Only HTML tags can be edited, not regular text.");
//                            return;
//                        }
//
//                        FileWriter fileWriter = new FileWriter(saveToFile);
//                        fileWriter.write(document);
//                        fileWriter.close();
//                        logger.log(SaveFileCommand.class, "File saved successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(window, "Cannot save file: Unable to create new file.");
                    }
                }
            }
            catch(IOException e) {
                JOptionPane.showMessageDialog(window, "Cannot save file: " + e.getMessage());
                logger.log(this.getClass(), "Unable to save file: " + e.getMessage(), Logger.ERROR);
            }
        }
        else {
            logger.log(this.getClass(), "Save as operation was cancelled.", Logger.ERROR);
        }
    }
}
