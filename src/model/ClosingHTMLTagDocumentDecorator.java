package model;

import controller.HTMLTreeVisitor;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class ClosingHTMLTagDocumentDecorator extends HTMLTagDocumentDecorator {
    public ClosingHTMLTagDocumentDecorator(DocumentComponent childComponent, String tag) {
        super(childComponent, tag);
    }

    @Override
    public void accept(HTMLTreeVisitor v) {
        super.accept(v);
        v.visitClosingHTMLTag(this.tag);
    }

    @Override
    public String toString() {
        return this.childComponent.toString() + this.tag;
    }
}
