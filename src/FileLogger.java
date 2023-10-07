import FileLoggerConfiguration.FileLoggerConfiguration;
import FileMaxSizeReachedException.FileMaxSizeReachedException;
import configuration.getLoggingLevel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    // спробувати через equals
private LoggingLevel level;
    private FileLoggerConfiguration configuration;
    private File logFile;
    private PrintWriter logWriter;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }



    public void debug(String message) throws FileMaxSizeReachedException {
        if (!configuration.getLoggingLevel().equals(level.DEBUG)) {
            log("[DEBUG] " + message);
        }
    }

    public void info(String message) throws FileMaxSizeReachedException {
        if (configuration.getLoggingLevel().equals(level.INFO)) {
            log("[INFO] " + message);
        } else {
            return;
        }
    }

    private void log(String message) throws FileMaxSizeReachedException {
        checkFileSize();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedMessage = "[" + dateFormat.format(new Date()) + "]" + message;
        logWriter.println(formattedMessage);
        logWriter.flush();
    }
// там повертає функція Object, тому і не хоче

    //Спробувати повертати там число
    private int checkFileSize() throws FileMaxSizeReachedException {
        if (logFile.length() >= configuration.getMaxFileSize()) {
            createNewLogFile();
            return 1; // або будь-яке інше ціле число, яке відповідає вашій логіці
        } else {
            return 0; // або будь-яке інше ціле число, яке відповідає вашій логіці
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