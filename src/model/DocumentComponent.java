package model;

import java.util.ArrayList;
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

    public Integer getNumberOfChildren() {
        return this.childComponents.size();
    }

    public Object createIterator(){
        // TODO: Implement Document Iteration
        return null;
    }
}
