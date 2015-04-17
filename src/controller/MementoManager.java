package controller;

import model.DocumentComponent;
import model.DocumentModel;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class MementoManager implements Observer {
    private DocumentModel documentModel;
    private DocumentComponent prevState;
    private Stack<DocumentMemento> undoStack;
    private Stack<DocumentMemento> redoStack;

    public MementoManager(DocumentModel documentModel) {
        this.documentModel = documentModel;
        this.documentModel.addObserver(this);

        this.prevState = this.documentModel.getDocumentRoot();

        this.undoStack = new Stack<DocumentMemento>();
        this.undoStack.push(new DocumentMemento(this.prevState));

        this.redoStack = new Stack<DocumentMemento>();
    }

    private DocumentMemento swapStacks(Stack<DocumentMemento> fromStack, Stack<DocumentMemento> toStack) {
        if(!fromStack.isEmpty()) {
            toStack.push(fromStack.peek());
            fromStack.pop();

            // FIXME: Getting NullPointerExceptions and EmptyStackExceptions
            this.prevState = fromStack.peek().getState();
            return fromStack.peek();
        }
        else {
            return null;
        }
    }

    public DocumentMemento undo() {
        return this.swapStacks(this.undoStack, this.redoStack);
    }

    public DocumentMemento redo() {
        return this.swapStacks(this.redoStack, this.undoStack);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(!this.prevState.toString().equals(this.documentModel.getDocumentRoot().toString())) {
            this.prevState = this.documentModel.getDocumentRoot();
            this.undoStack.push(new DocumentMemento(this.documentModel.getDocumentRoot()));
            this.redoStack.clear();
        }
    }
}
