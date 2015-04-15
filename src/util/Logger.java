package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class Logger extends Observable {
    private static Logger ourInstance = new Logger();

    public static Logger getInstance() {
        return ourInstance;
    }

    public static final String TRACE   = "[TRACE]";
    public static final String DEBUG   = "[DEBUG]";
    public static final String INFO    = "[INFO]";
    public static final String WARNING = "[WARN]";
    public static final String ERROR   = "[ERROR]";
    public static final String FATAL   = "[FATAL]";

    private List<String> previousMessages;

    private File logFile;
    private SimpleDateFormat dateFormatter;
    private Logger() {
        this.previousMessages = new ArrayList<String>();

        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.logFile = new File("logger.log");
    }

    public List<String> getPreviousMessages() {
        return previousMessages;
    }

    public void log(Class cls, String message) {
        this.log(cls, message, TRACE);
    }

    public void log(Class cls, String message, String priority) {
        try {
            String log = String.format("%7s %s - %10s: %s\n",
                    priority,
                    this.dateFormatter.format(new Date()),
                    cls,
                    message
            );

            this.previousMessages.add(log);

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.logFile, true)));
            out.printf(log);

            out.close();

            this.setChanged();
            this.notifyObservers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
