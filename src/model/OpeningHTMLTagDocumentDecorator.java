package model;

import controller.HTMLTreeVisitor;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class OpeningHTMLTagDocumentDecorator extends HTMLTagDocumentDecorator {
    public OpeningHTMLTagDocumentDecorator(DocumentComponent childComponent, String tag) {
        super(childComponent, tag);
    }

    @Override
    public void accept(HTMLTreeVisitor v) {
        super.accept(v);
        v.visitOpeningHTMLTag(this.tag);
    }

    @Override
    public String toString() {
        return this.tag + this.childComponent.toString();
    }
}
