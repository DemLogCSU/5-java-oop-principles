package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static final Map<String, Logger> LOGGERS = new HashMap<>();

    private final String name;
    private LogLevel level = LogLevel.DEBUG;

    public Logger(String name) {
        this.name = name;
    }

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public static Logger getLogger(String name) {
        Logger logger = LOGGERS.get(name);
        if (logger == null) {
            LOGGERS.put(name, logger = new Logger(name));
        }
        return logger;
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void log(LogLevel level, String message, Object... args) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, MessageFormat.format(message, args)));
        }
    }

    public void log(LogLevel level, String message) {
        log(level, message, new Object[0]);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(LogLevel.DEBUG, message, args);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String message, Object... args) {
        log(LogLevel.INFO, message, args);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(LogLevel.WARNING, message, args);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(LogLevel.ERROR, message, args);
    }
}