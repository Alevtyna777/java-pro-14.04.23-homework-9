import FileLoggerConfiguration.FileLoggerConfiguration;

import java.io.IOException;

public class FileLoggerImpl extends FileLogger {
    public FileLoggerImpl(FileLoggerConfiguration configuration) throws IOException {
        super(configuration);
    }
}
