package controller;

import util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Richard Killam, 3412522 on 16/04/15.
 */
public class HTMLTreeVisitor {
    private static final Logger logger = Logger.getInstance();
    private static final Pattern tagType = Pattern.compile("<\\/?(\\w+?)>");

    private Stack<String> htmlTree;
    private Boolean isValidTree;

    public HTMLTreeVisitor() {
        this.htmlTree = new Stack<String>();
        this.isValidTree = true;
    }

    public void visitClosingHTMLTag(String tag) {
        if(!this.htmlTree.empty()) {
            this.isValidTree &= this.compareTags(tag, this.htmlTree.peek());
            this.htmlTree.pop();
        }
        else {
            this.isValidTree = false;
        }
    }

    public void visitOpeningHTMLTag(String tag) {
        this.htmlTree.push(tag);
    }

    private List<String> groupTagTypes(String tag) {
        List<String> groups = new ArrayList<String>();

        Matcher tagMatcher = tagType.matcher(tag);
        while(tagMatcher.find()) {
            for(Integer i = 1; i <= tagMatcher.groupCount(); ++i) {
                groups.add(tagMatcher.group(i));
            }
        }

        return groups;
    }

    private Boolean compareTags(String tag1, String tag2) {
        List<String> tag1Types = this.groupTagTypes(tag1);
        List<String> tag2Types = this.groupTagTypes(tag2);

        if(tag1Types.size() == 1 && tag2Types.size() == 1) {
            String tag1Type = tag1Types.get(0);
            String tag2Type = tag2Types.get(0);

            logger.log(
                    this.getClass(),
                    "tag1Type: " + tag1Type + " == tag2Type: " + tag2Type,
                    Logger.DEBUG
            );

            return tag1Type.equals(tag2Type);
        }
        else {
            return false;
        }
    }

    public Boolean isValidTree() {
        return this.isValidTree && this.htmlTree.empty();
    }
}
