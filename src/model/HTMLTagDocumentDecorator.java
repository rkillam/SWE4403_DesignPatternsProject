package model;

import controller.HTMLTreeVisitor;

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

    @Override
    public void addChild(DocumentComponent newChild) {
        this.childComponent.addChild(newChild);
    }

    @Override
    public void removeChild(DocumentComponent oldChild) {
        this.childComponent.removeChild(oldChild);
    }

    @Override
    public DocumentComponent getChild(Integer index) {
        return this.childComponent.getChild(index);
    }

    @Override
    public Integer getNumberOfChildren() {
        return this.childComponent.getNumberOfChildren();
    }

    @Override
    public void accept(HTMLTreeVisitor v) {
        this.childComponent.accept(v);
    }

    @Override
    public Iterator<DocumentComponent> createIterator(){
        return this.childComponent.createIterator();
    }
}
