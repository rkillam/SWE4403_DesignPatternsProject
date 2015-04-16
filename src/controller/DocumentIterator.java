package controller;

import model.DocumentComponent;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class DocumentIterator {
    private DocumentComponent root;
    private DocumentComponent currentComponent;
    private Stack<Iterator<DocumentComponent>> iteratorStack;

    public DocumentIterator(DocumentComponent root) {
        this.root = root;
        this.iteratorStack = new Stack<Iterator<DocumentComponent>>();

        this.first();
    }

    public void first() {
        this.iteratorStack.clear();
        this.iteratorStack.push(this.root.createIterator());
        this.next();
    }

    public void next() {
        this.pruneIteratorStack();

        if(!this.iteratorStack.empty()) {
            Iterator<DocumentComponent> nextIterator = this.iteratorStack.peek();
            this.currentComponent = nextIterator.next();
            this.iteratorStack.push(this.currentComponent.createIterator());
        }
    }

    public DocumentComponent currentComponent() {
        return this.currentComponent;
    }

    public Boolean hasNext() {
        return !this.iteratorStack.empty();
    }

    private void pruneIteratorStack() {
        while(!this.iteratorStack.empty() && !this.iteratorStack.peek().hasNext()) {
            this.iteratorStack.pop();
        }
    }
}
