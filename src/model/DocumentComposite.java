package model;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentComposite extends DocumentComponent {
    public void addChild(DocumentComponent newChild) {
        this.childComponents.add(newChild);
    }

    public void removeChild(DocumentComponent oldChild) {
        this.childComponents.remove(oldChild);
    }

    public DocumentComponent getChild(Integer index) {
        DocumentComponent wantedChild;
        if(index < 0) {  // Allows for Python style negative indexing
            wantedChild = this.childComponents.get(this.getNumberOfChildren() + index);
        }
        else {
            wantedChild = this.childComponents.get(index);
        }

        return wantedChild;
    }

    @Override
    public String toString() {
        String retString = "";
        for(DocumentComponent child : this.childComponents) {
            retString += child.toString();
        }

        return retString;
    }
}
