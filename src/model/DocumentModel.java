package model;

import java.io.File;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentModel {
    private DocumentComponent documentRoot;
    private File saveFile;

    public DocumentModel(DocumentComponent documentRoot) {
        this.documentRoot = documentRoot;
        this.saveFile = null;
    }

    public File getSaveFile() {
        return this.saveFile;
    }

    @Override
    public String toString() {
        return this.documentRoot.toString();
    }
}
