package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Richard Killam, 3412522 on 14/04/15.
 */
public class Logger {
    private static Logger ourInstance = new Logger();

    public static Logger getInstance() {
        return ourInstance;
    }

    File logFile;
    SimpleDateFormat dateFormatter;
    private Logger() {
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.logFile = new File("logger.log");
    }

    public void log(Class cls, String message) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.logFile, true)));
            out.printf("%s - %10s: %s\n", this.dateFormatter.format(new Date()),
                                            cls,
                                            message
            );

            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
