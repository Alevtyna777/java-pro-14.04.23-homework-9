
public class FileLoggerBuilder {
    public FileLoggerConfiguration configuration;
    /*
      public FileLoggerConfiguration filelogger
    private FileLoggerConfiguration loggerConfiguration;
     private FileLoggerConfiguration.FileLoggerConfigurationFileLoggerConfiguration;
    */

    public FileLoggerBuilder setConfiguration(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public FileLoggerBuilder setLoggerConfig(FileLoggingCOnfigurationLoader loggerConfig) {
        return setLoggerConfig((loggerConfig) null);// отже я не передала параметр
    }

    public FileLogger createFileLogger() {
        return null;
    }}

   //public FileLoggerBuilder setLoggerConfig(FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration loggerConfig) {
       // this.loggerConfig = loggerConfig;
      // return this;
   // }


    //public FileLogger createFileLogger() {
     //  FileLoggerConfiguration.FileLoggerConfiguration.FileLoggerConfiguration FileLoggerConfiguration = null;

      //  return null;
   // }

    //private class FileLoggerConfiguration {
   // }
//}
