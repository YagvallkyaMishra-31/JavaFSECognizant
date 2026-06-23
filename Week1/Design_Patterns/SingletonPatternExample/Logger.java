import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger class that follows the Singleton Design Pattern.
 * 
 * The idea behind Singleton is that some classes should only ever have ONE instance
 * in the entire application. A logger is a great example — you don't want multiple
 * logger objects writing to different places, you want one centralized logger.
 * 
 * We use "double-checked locking" here to make it thread-safe without
 * synchronizing every single call to getInstance(). The volatile keyword
 * makes sure the instance variable is always read from main memory,
 * not from a thread's local cache.
 */
public class Logger {

    // volatile ensures visibility across threads — if one thread creates the instance,
    // other threads will immediately see it (no stale cache issues)
    private static volatile Logger instance;

    // formatter for timestamps in log messages
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Private constructor — nobody outside this class can call "new Logger()"
    // This is the key to Singleton: we control object creation ourselves
    private Logger() {
        System.out.println("Logger instance created.");
    }

    /**
     * Returns the single Logger instance, creating it if needed.
     * 
     * Double-checked locking works like this:
     * 1. First check (without lock) — fast path for when instance already exists
     * 2. If null, enter synchronized block so only one thread can create it
     * 3. Second check (inside lock) — in case another thread created it while we waited
     */
    public static Logger getInstance() {
        if (instance == null) {                  // first check — no lock needed
            synchronized (Logger.class) {        // only one thread gets in here at a time
                if (instance == null) {           // second check — prevents duplicate creation
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Logs a message with a timestamp prefix.
     * Example output: [2024-06-23 10:15:30] Application started
     */
    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] " + message);
    }
}
