package view.components;

import controller.BackendFacade;
import util.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class TextEditorPane extends JTextPane {
    private BackendFacade backendFacade;
    private String previousState;
    private static final Logger logger = Logger.getInstance();

    public TextEditorPane(BackendFacade backendFacade) {
        super();

        this.backendFacade = backendFacade;
        this.previousState = null;

        addKeyListener(new DocumentChangedListener());

        logger.log(this.getClass(), "Text Editor ready");
    }

    private class DocumentChangedListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            logger.log(this.getClass(), "Key pressed");
            if(!keyEvent.isActionKey()) {
                String content = TextEditorPane.this.getText();

                if(!content.equals(previousState)) {
                    previousState = content;
                    backendFacade.update(content);
                }
            }
        }
    }
}
