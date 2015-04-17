package controller;

import model.DocumentComponent;
import model.DocumentModel;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class DocumentMemento {
    private DocumentComponent memento;
    public DocumentMemento(DocumentComponent memento) {
        this.memento = memento;
    }

    public DocumentComponent getState() {
        return this.memento;
    }
}
