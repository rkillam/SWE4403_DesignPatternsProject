package view.components;

import util.Logger;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DebugConsole extends JTextPane implements Observer {
    private static final Logger logger = Logger.getInstance();

    public DebugConsole() {
        logger.addObserver(this);

        this.setEditable(false);
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public void update(Observable observable, Object o) {
        String log = "";
        for(String message : logger.getPreviousMessages()) {
            log += message;
        }
        this.setText(log);
    }
}
