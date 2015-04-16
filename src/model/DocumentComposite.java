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

    @Override
    public String toString() {
        String retString = "";
        for(DocumentComponent child : this.childComponents) {
            retString += child.toString();
        }

        return retString;
    }
}
