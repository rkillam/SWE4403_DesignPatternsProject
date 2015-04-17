package controller;

import model.DocumentComponent;
import model.DocumentModel;
import util.Logger;
import view.windows.Window;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class BackendFacade extends Observable {
    private static Logger logger = Logger.getInstance();

    private HTMLTreeValidator htmlTreeValidator;
    private DocumentModel documentModel;
    private MementoManager mementoManager;

    public BackendFacade() {
        this.htmlTreeValidator = HTMLTreeValidator.getInstance();
        this.documentModel = new DocumentModel();
        this.createDocumentTree("");

        this.mementoManager = new MementoManager(this.documentModel);
    }

    public DocumentModel getDocumentModel() {
        return documentModel;
    }

    public File getSaveFile() {
        return this.documentModel.getSaveFile();
    }

    public void setSaveFile(File file) {
        this.documentModel.setSaveFile(file);
    }

    public Boolean isDocumentValid() {
        return this.htmlTreeValidator.isHTMLTreeValid(this.documentModel.getDocumentRoot());
    }

    private void createDocumentTree(String documentString) {
        DocumentModelBuilder builder = new DocumentModelBuilder();

        builder.build(documentString);
        this.documentModel.setDocumentRoot(builder.getResult());
    }

    public void undo() {
        DocumentMemento memento = this.mementoManager.undo();
        if(memento != null) {
            this.documentModel.setDocumentRoot(memento.getState());
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void redo() {
        DocumentMemento memento = this.mementoManager.redo();
        if(memento != null) {
            this.documentModel.setDocumentRoot(memento.getState());
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void update(String documentContent) {
        this.update(documentContent, false);
    }

    public void update(String documentContent, Boolean updateTextPane) {
        this.createDocumentTree(documentContent);

        if(updateTextPane) {
            this.setChanged();
            this.notifyObservers();
        }
    }

    public String getDocumentString() {
        return this.documentModel.getDocumentString();
    }
}
