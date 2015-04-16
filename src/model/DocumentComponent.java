package model;

import controller.HTMLTreeVisitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public abstract class DocumentComponent {
    List<DocumentComponent> childComponents;

    public DocumentComponent() {
        this.childComponents = new ArrayList<DocumentComponent>();
    }

    @Override
    public abstract String toString();

    public void addChild(DocumentComponent newChild){}
    public void removeChild(DocumentComponent oldChild){}
    public DocumentComponent getChild(Integer index){ return null; }
    public void accept(HTMLTreeVisitor v){}

    public Integer getNumberOfChildren() {
        return this.childComponents.size();
    }

    public Iterator<DocumentComponent> createIterator(){
        return this.childComponents.iterator();
    }
}
