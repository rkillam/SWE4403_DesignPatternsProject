package view.commands;

import backend.BackendFacade;
import util.Logger;
import view.windows.Window;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class OpenCommand implements Command {
    private static final Logger logger = Logger.getInstance();
    private Window window;
    private BackendFacade backendFacade;

    public OpenCommand(Window window, BackendFacade backendFacade) {
        this.window = window;
        this.backendFacade = backendFacade;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        Integer returnValue = fileChooser.showOpenDialog(this.window);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Scanner scanner = null;
            String result = "";

            logger.log(this.getClass(), "Chose file: " + file.getName());

            try {
                scanner = new Scanner(file).useDelimiter("\\Z");
                result = scanner.next();
            }
            catch(IOException e) {
                logger.log(this.getClass(), "Unable to read file: " + e.getMessage());
            }
            catch(NoSuchElementException e) {
                logger.log(this.getClass(), "Empty file! " + e.getMessage());
            }
            finally {
                if(scanner != null) {
                    scanner.close();
                }
            }
        }
        else {
            logger.log(this.getClass(), "Open file operation aborted", Logger.ERROR);
        }
    }
}
