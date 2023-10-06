import FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration;

public class FileLoggerBuilder {
    private FileLoggerConfiguration configuration;
    private FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration loggerConfig;
    private FileLoggerConfiguration loggerConfiguration;
   // private FileLoggerConfiguration.FileLoggerConfigurationFileLoggerConfiguration;

    public FileLoggerBuilder setConfiguration(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public FileLoggerBuilder setLoggerConfig(FileLoggingCOnfigurationLoader loggerConfig) {
        return setLoggerConfig((FileLoggingCOnfigurationLoader) null);
    }

    public FileLoggerBuilder setLoggerConfig(FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration loggerConfig) {
        this.loggerConfig = loggerConfig;
        return this;
    }


    public FileLogger createFileLogger() {
        FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration FileLoggerConfiguration = null;
        FileLogger fileLogger = new FileLogger((FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration) null);
        return fileLogger;
    }
}
