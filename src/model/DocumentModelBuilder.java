package model;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentModelBuilder {
    private DocumentComponent rootComponent;
    private DocumentComponent currentComposite;
    private DocumentItemFlyweightFactory flyweightFactory;

    public DocumentModelBuilder() {
        this.rootComponent = new DocumentComposite();
        this.currentComposite = this.rootComponent;

        this.flyweightFactory = DocumentItemFlyweightFactory.getInstance();
    }

    public void addLine(String line) {
        DocumentComposite row = new DocumentComposite();

        for(Character c : line.toCharArray()) {
            row.addChild(this.flyweightFactory.lookup(c));
        }

        this.currentComposite.addChild(new DocumentRowDecorator(row));
    }

    public DocumentModel getResult() {
        return new DocumentModel(this.rootComponent);
    }
}