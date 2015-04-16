package model;

import java.util.Iterator;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public abstract class HTMLTagDocumentDecorator extends DocumentComponent {
    protected DocumentComponent childComponent;
    protected String tag;

    public HTMLTagDocumentDecorator(DocumentComponent childComponent, String tag) {
        this.childComponent = childComponent;
        this.tag = tag;
    }

    public void addChild(DocumentComponent newChild) {
        this.childComponent.addChild(newChild);
    }

    public void removeChild(DocumentComponent oldChild) {
        this.childComponent.removeChild(oldChild);
    }

    public DocumentComponent getChild(Integer index) {
        return this.childComponent.getChild(index);
    }

    public Iterator<DocumentComponent> createIterator(){
        return this.childComponent.createIterator();
    }
}
