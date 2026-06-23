/**
 * Test class to demonstrate the Singleton pattern with our Logger.
 * 
 * We grab two references from getInstance() and check if they're
 * literally the same object in memory using ==.
 */
public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===\n");

        // Get two references to the Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the exact same object
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("\nResult: Both references point to the SAME object. Singleton works!\n");
        } else {
            System.out.println("\nResult: References are DIFFERENT. Something went wrong!\n");
        }

        // Use both references to log — they should behave identically
        // since they're the same object
        System.out.println("--- Logging through logger1 ---");
        logger1.log("This message is logged via logger1");

        System.out.println("--- Logging through logger2 ---");
        logger2.log("This message is logged via logger2");

        System.out.println("\nBoth log calls went through the same Logger instance.");
    }
}
