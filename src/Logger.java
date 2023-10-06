//public interface Logger {
    // Цей інтерфейс чи абстрактний клас "Logger" повинен визначати методи такі як debug,info
//}
import FileLoggerConfiguration.FileLoggerConfiguration;
import FileMaxSizeReachedException.FileMaxSizeReachedException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private FileLoggerConfiguration configuration;
    private File logFile;
    private PrintWriter logWriter;

    public FileLogger(FileLoggerConfiguration loggerConfig) {
    }

   // public FileLogger(FileLoggerConfiguration configuration) {
    //}

    public FileLogger(FileLoggerConfiguration.FileLoggerConfiguration ) {
    }

    public FileLogger(FileLoggerConfiguration.FileLoggerConfiguration o) {
    }




    public void debug(String message) throws FileMaxSizeReachedException {
        if (configuration.getLoggingLevel() == LoggingLevel.DEBUG) {
            log("[DEBUG] " + message);
        }
    }

    public void info(String message) throws FileMaxSizeReachedException {
        if (configuration.getLoggingLevel() != LoggingLevel.INFO) {
            return;
        }
        log("[INFO] " + message);

    }

    private void log(String message) throws FileMaxSizeReachedException {
        checkFileSize();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedMessage = "[" + dateFormat.format(new Date()) + "]" + message;
        logWriter.println(formattedMessage);
        logWriter.flush();
    }

    private void checkFileSize() throws FileMaxSizeReachedException {
        if (logFile.length() >= configuration.getMaxFileSize()) {
            createNewLogFile();
        }
    }




    private void createNewLogFile() throws FileMaxSizeReachedException {
        // Створення нового файлу з унікальною назвою, включаючи дату
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String newFileName = "Log_" + dateFormat.format(new Date()) + ".txt";
        File newLogFile = new File(configuration.getLogFilePath(), newFileName);

        // Перевірка чи файл був успішно створений
        if (logFile.renameTo(newLogFile)) {
            try {
                logFile.createNewFile();
                logWriter.close();
                logWriter = new PrintWriter(new FileWriter(logFile, true));
            } catch (IOException e) {
                throw new FileMaxSizeReachedException("Failed to create a new log file.", logFile.length(), configuration.getMaxFileSize(), logFile.getPath());
            }
        } else {
            throw new FileMaxSizeReachedException("Failed to rename the log file.", logFile.length(), configuration.getMaxFileSize(), logFile.getPath());
        }
    }
}
