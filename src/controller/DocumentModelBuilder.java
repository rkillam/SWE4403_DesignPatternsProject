package controller;

import model.*;
import util.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentModelBuilder {
    private static final Logger logger = Logger.getInstance();

    private DocumentComponent rootComponent;
    private Stack<DocumentComponent> componentStack;
    private DocumentItemFlyweightFactory flyweightFactory;

    public DocumentModelBuilder() {
        this.rootComponent = new DocumentComposite();
        this.componentStack = new Stack<DocumentComponent>();
        this.componentStack.push(this.rootComponent);

        this.flyweightFactory = DocumentItemFlyweightFactory.getInstance();
    }

    public void build(String content) {
        class RegexMatch {
            public Integer start;
            public Integer end;
            public String group;

            public RegexMatch(Integer start, Integer end, String group) {
                this.start = start;
                this.end = end;
                this.group = group;
            }
        }

        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(content);

        Queue<RegexMatch> matches = new LinkedList<RegexMatch>();
        // Check all occurrences
        while (matcher.find()) {
            matches.add(new RegexMatch(
                    matcher.start(),
                    matcher.end(),
                    matcher.group()
            ));
        }

        char[] characterList = content.toCharArray();
        for(Integer i = 0; i < characterList.length; ++i) {
            if(!matches.isEmpty() && i.equals(matches.peek().start)) {
                String match = matches.peek().group;
                if(match.matches("<[^/]+/>")) {  // Single HTML tag
                    DocumentComponent lastChild;
                    if(this.componentStack.peek().getNumberOfChildren() > 0) {
                        lastChild = this.componentStack.peek().getChild(-1);
                        this.componentStack.peek().removeChild(lastChild);
                    }
                    else {
                        lastChild = this.flyweightFactory.lookup('\0');
                    }

                    this.componentStack.peek().addChild(new SelfClosingHTMLTagDocumentDecorator(lastChild, match));
                }
                else {  // Paired HTML tag
                    if(match.matches("<[^/]+>")) {
                        DocumentComponent tagBlock = new OpeningHTMLTagDocumentDecorator(new DocumentComposite(), match);
                        this.componentStack.peek().addChild(tagBlock);
                        this.componentStack.push(tagBlock);
                    }
                    else {
                        DocumentComponent lastTagBlock = this.componentStack.peek();
                        this.componentStack.pop();
                        this.componentStack.peek().removeChild(lastTagBlock);
                        this.componentStack.peek().addChild(new ClosingHTMLTagDocumentDecorator(lastTagBlock, match));
                    }
                }

                i = matches.poll().end - 1;
            }
            else {
                Character c = characterList[i];

                this.componentStack.peek().addChild(this.flyweightFactory.lookup(c));
            }
        }
    }

    public DocumentComponent getResult() {
        return this.rootComponent;
    }
}
