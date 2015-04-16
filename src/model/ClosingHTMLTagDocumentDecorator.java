package model;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class ClosingHTMLTagDocumentDecorator extends HTMLTagDocumentDecorator {
    public ClosingHTMLTagDocumentDecorator(DocumentComponent childComponent, String tag) {
        super(childComponent, tag);
    }

    @Override
    public String toString() {
        return this.childComponent.toString() + this.tag;
    }
}
