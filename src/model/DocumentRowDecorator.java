package model;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentRowDecorator extends DocumentComponent {
    DocumentComponent wrappedComponent;

    public DocumentRowDecorator(DocumentComponent wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    @Override
    public String toString() {
        return this.wrappedComponent.toString() + "\n";
    }
}
