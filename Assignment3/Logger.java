import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger uniqueInstance;
    private final SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private Logger() {                         
    }

    public static Logger getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Logger();
        }
        return uniqueInstance;
    }

    public void log(String className) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(dateTime.format(new Date()) + " " + className + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write log entry.");
        }
    }
  
}