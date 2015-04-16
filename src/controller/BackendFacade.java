package controller;

import model.DocumentModel;
import model.DocumentModelBuilder;
import util.Logger;
import view.windows.Window;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class BackendFacade extends Observable implements Observer {
    private static Logger logger = Logger.getInstance();
    private Window window;

    private DocumentModel documentModel;

    public BackendFacade(Window window) {
        this.window = window;
        this.documentModel = new DocumentModel();
    }

    public DocumentModel getDocumentModel() {
        return documentModel;
    }

    public File getSaveFile() {
        return this.documentModel.saveFile;
    }

    public void setSaveFile(File file) {
        this.documentModel.saveFile = file;
    }

    private void createDocumentTree(String documentString) {
        DocumentModelBuilder builder = new DocumentModelBuilder();

        builder.build(documentString);
        this.documentModel.documentRoot = builder.getResult();
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

    @Override
    public void update(Observable observable, Object o) {
        logger.log(this.getClass(), "Update Occurred");
    }
}
