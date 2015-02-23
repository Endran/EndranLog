package nl.endran.logger;

import java.util.HashMap;

public class LoggerFactory {
    private static LogLevel _logLevel = LogLevel.VERBOSE;
    private static String _tag = "UninitializedLogTag";
    private static final HashMap<String, LogLevel> logLevelMap = new HashMap<String, LogLevel>();

    public static void setLogLevel(final LogLevel logLevel) {
        _logLevel = logLevel;
    }

    public static void setSpecificLogLevel(final Object object, final LogLevel logLevel) {
        setSpecificLogLevel(object.getClass(), logLevel);
    }

    public static void setSpecificLogLevel(final Class<?> clazz, final LogLevel logLevel) {
        setSpecificLogLevel(clazz.getSimpleName(), logLevel);
    }

    public static void setSpecificLogLevel(final String classSimpleName, final LogLevel logLevel) {
        logLevelMap.put(classSimpleName, logLevel);
    }

    public static void setLogTag(final String tag) {
        _tag = tag;
    }

    public static String getLogTag() {
        return _tag;
    }

    /**
     * Create a ILogger instance for a class. Usually object is a callers
     * <b>this</b>. Will call #GetLoggerWithString(object.getClass().getSimpleName())
     *
     * @param object A callers <b>this</b>
     * @return ILogger instance
     */
    public static Logger getLogger(final Object object) {
        return getLogger(object.getClass());
    }

    public static Logger getLogger(final Class<?> clazz) {
        return getLogger(clazz.getSimpleName());
    }

    /**
     * Create a ILogger instance for a class. Usually object is a callers
     * simpleName
     *
     * @param string A name, to prefix each log message
     * @return ILogger instance
     */
    public static Logger getLogger(final String string) {
        LogLevel logLevel = getLogLevel(string);
        return getLogger(string, logLevel);
    }

    private static Logger getLogger(final String string, final LogLevel logLevel) {
        switch (logLevel) {
            case VERBOSE:
                return new LoggerVerbose(_tag, string);
            case DEBUG:
                return new LoggerDebug(_tag, string);
            case INFO:
                return new LoggerInfo(_tag, string);
            case WARN:
                return new LoggerWarn(_tag, string);
            case ERROR:
                return new LoggerError(_tag, string);
            case SILENT:
            default:
                return new LoggerSilent();
        }
    }

    private static LogLevel getLogLevel(final String string) {
        LogLevel logLevel = logLevelMap.get(string);
        if (logLevel == null) {
            logLevel = _logLevel;
        }
        return logLevel;
    }
}
