package controller;

import model.DocumentModel;
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

    private HTMLTreeValidator htmlTreeValidator;
    private DocumentModel documentModel;

    public BackendFacade() {
        this.htmlTreeValidator = HTMLTreeValidator.getInstance();
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

    public Boolean isDocumentValid() {
        return this.htmlTreeValidator.isHTMLTreeValid(this.documentModel.documentRoot);
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
