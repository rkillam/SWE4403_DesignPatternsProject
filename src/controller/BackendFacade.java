package controller;

import model.*;
import util.Logger;
import view.windows.Window;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class BackendFacade implements Observer {
    private static Logger logger = Logger.getInstance();
    private Window window;

    private DocumentModel documentModel;
    private DocumentModelDirector documentModelDirector;

    public BackendFacade(Window window) {
        this.window = window;
        this.documentModelDirector = DocumentModelDirector.getInstance();
    }

    public DocumentModel getDocumentModel() {
        return documentModel;
    }

    public File getSaveFile() {
        return this.documentModel.getSaveFile();
    }

    public void update(String documentContent) {
        this.documentModel = this.documentModelDirector.createDocumentModel(documentContent);
    }

    @Override
    public void update(Observable observable, Object o) {
        logger.log(this.getClass(), "Update Occurred");
    }
}
