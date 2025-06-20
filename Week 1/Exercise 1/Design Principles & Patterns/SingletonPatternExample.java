// SingletonPatternExample.java

public class SingletonPatternExample {

    // Singleton Logger class
    static class Logger {
        // Private static instance of Logger
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger Initialized");
        }

        // Public static method to return the single instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Main method to test Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second message");

        // Verify if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("Different instances found! Singleton failed.");
        }
    }
}
