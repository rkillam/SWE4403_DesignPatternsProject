package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class KeyboardShortcutBuilder {
    public static final String ALT = "alt";
    public static final String COMMAND = "command";
    public static final String CONTROL = "control";
    public static final String FUNCTION = "function";
    public static final String SHIFT = "shift";

    private List<String> commandKeySequence;
    private String key;

    public KeyboardShortcutBuilder() {
        this.commandKeySequence = new ArrayList<String>();
        this.key = "";
    }

    public KeyboardShortcutBuilder addCommandKey(String commandKey) {
        this.commandKeySequence.add(commandKey);

        return this;
    }

    public KeyboardShortcutBuilder setKey(Character key) {
        this.key = key.toString().toUpperCase();

        return this;
    }

    public String getResult() {
        String result = "";
        for(String commandKey : this.commandKeySequence) {
            result += commandKey + " ";
        }

        return result + this.key;
    }
}
