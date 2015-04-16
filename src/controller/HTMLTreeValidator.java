package controller;

import model.DocumentComponent;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class HTMLTreeValidator {
    private static HTMLTreeValidator ourInstance = new HTMLTreeValidator();

    public static HTMLTreeValidator getInstance() {
        return ourInstance;
    }

    private HTMLTreeValidator() {}

    public Boolean isHTMLTreeValid(DocumentComponent documentRoot) {
        HTMLTreeVisitor visitor = new HTMLTreeVisitor();

        if(documentRoot != null) {
            DocumentIterator documentIterator = new DocumentIterator(documentRoot);
            while(documentIterator.hasNext()) {
                documentIterator.currentComponent().accept(visitor);
                documentIterator.next();
            }
        }

        return visitor.isValidTree();
    }
}
