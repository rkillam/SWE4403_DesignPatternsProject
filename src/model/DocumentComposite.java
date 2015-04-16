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
        return this.childComponents.get(index);
    }

    @Override
    public String toString() {
        return "";
    }
}
