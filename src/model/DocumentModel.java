package model;

import java.io.File;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentModel {
    public DocumentComponent documentRoot;
    public File saveFile;

    public DocumentModel() {
        this.documentRoot = null;
        this.saveFile = null;
    }

    @Override
    public String toString() {
        return this.documentRoot.toString();
    }
}
