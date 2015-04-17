package model;

import java.io.File;
import java.util.Observable;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentModel extends Observable{
    private DocumentComponent documentRoot;
    private File saveFile;

    public DocumentModel() {
        this.documentRoot = null;
        this.saveFile = null;
    }

    public DocumentComponent getDocumentRoot() {
        return documentRoot;
    }

    public void setDocumentRoot(DocumentComponent documentRoot) {
        this.documentRoot = documentRoot;
        this.setChanged();
        this.notifyObservers();
    }

    public File getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(File saveFile) {
        this.saveFile = saveFile;
    }

    public String getDocumentString() {
        return this.documentRoot.toString();
    }
}
