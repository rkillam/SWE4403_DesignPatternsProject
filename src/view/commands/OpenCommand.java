package view.commands;

import controller.BackendFacade;
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
public class OpenCommand extends Command {
    private Window window;

    public OpenCommand(Window window, BackendFacade backendFacade) {
        super(backendFacade);
        this.window = window;
    }

    @Override
    public void execute() {
        super.execute();
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
