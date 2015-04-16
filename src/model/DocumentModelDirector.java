package model;


import util.Logger;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentModelDirector {
    private static Logger logger = Logger.getInstance();
    private static DocumentModelDirector ourInstance = new DocumentModelDirector();

    public static DocumentModelDirector getInstance() {
        return ourInstance;
    }

    private DocumentModelDirector() {}

    public DocumentModel createDocumentModel(String documentString) {
        DocumentModelBuilder builder = new DocumentModelBuilder();

        for(String line : documentString.split("\\r?\\n")) {
            builder.addLine(line);
        }

        return builder.getResult();
    }
}
