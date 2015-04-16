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

    public String getDocumentString() {
        String retString = "";

        if(this.documentRoot != null) {
            DocumentIterator documentIterator = new DocumentIterator(this.documentRoot);
            while(documentIterator.hasNext()) {
                retString += documentIterator.currentComponent().toString();
                documentIterator.next();
            }
        }

        return retString;
    }
}
