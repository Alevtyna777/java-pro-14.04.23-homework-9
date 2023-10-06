import FileMaxSizeReachedException.FileMaxSizeReachedException;

public class Main {
    public static void main(String[] args) {
        // Створюємо конфігурацію для логування
        FileLoggingCOnfigurationLoader loggerConfig = new FileLoggingCOnfigurationLoader();
        loggerConfig.setLogFilePath("log.txt");
        loggerConfig.setLoggingLevel(LoggingLevel.DEBUG);
        loggerConfig.setMaxFileSize(1024); // Наприклад, 1 кілобайт
        loggerConfig.setLogFormat("[TIME][LEVEL] Message: [MESSAGE]");

        try {
            // Створюємо об'єкт FileLogger і передаємо конфігурацію
            FileLoggingCOnfigurationLoader Configuration;
            FileLoggingCOnfigurationLoader configuration;
            FileLogger logger = new FileLoggerBuilder().setLoggerConfig(loggerConfig).createFileLogger();

            // Використовуємо методи debug та info для логування
            logger.debug("This is a debug message.");
            logger.info("This is an info message.");

        } catch (FileMaxSizeReachedException e) {
            System.err.println("Max file size reached: " + e.getMessage());
        }
    }
}