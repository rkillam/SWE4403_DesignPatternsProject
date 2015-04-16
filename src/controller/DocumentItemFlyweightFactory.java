package controller;

import model.DocumentItem;

import java.util.HashMap;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentItemFlyweightFactory {
    private static DocumentItemFlyweightFactory ourInstance = new DocumentItemFlyweightFactory();

    public static DocumentItemFlyweightFactory getInstance() {
        return ourInstance;
    }

    HashMap<Integer, DocumentItem> documentItemPool;
    private DocumentItemFlyweightFactory() {
        this.documentItemPool = new HashMap<Integer, DocumentItem>();
    }

    public DocumentItem lookup(char character) {
        if(!this.documentItemPool.containsKey((int)character)) {
            this.documentItemPool.put((int)character, new DocumentItem(character));
        }

        return this.documentItemPool.get((int)character);
    }
}
