package com.ebson.skillserver.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.filter.LevelFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class LoggingConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggingConfig.class);

    @Configuration
    @Profile("test")
    public static class DevLoggingConfiguration {
        public DevLoggingConfiguration() {
            configureConsoleLogging();
        }

        private void configureConsoleLogging() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<>();
            consoleAppender.setContext(context);
            consoleAppender.setName("CONSOLE");

            PatternLayoutEncoder encoder = new PatternLayoutEncoder();
            encoder.setContext(context);
            encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
            encoder.start();

            consoleAppender.setEncoder(encoder);
            consoleAppender.start();

            // context.getLogger("com.example.myapp").setLevel(ch.qos.logback.classic.Level.DEBUG);
            context.getLogger(Logger.ROOT_LOGGER_NAME).addAppender(consoleAppender);
        }
    }

    @Configuration
    @Profile("dev")
    public static class RollingFileLoggingConfiguration {
        public RollingFileLoggingConfiguration() {
            configureErrorFileLogging();
            configureTraceFileLogging();
            configureDebugFileLogging();
            configureInfoFileLogging();
            configureWarnFileLogging();
        }

        private void configureErrorFileLogging() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
            rollingFileAppender.setContext(context);
            rollingFileAppender.setName("ERROR_LOGGER");
            rollingFileAppender.setFile("logs/error.log");

            LevelFilter levelFilter = new LevelFilter();
            levelFilter.setLevel(Level.ERROR);
            levelFilter.setOnMatch(FilterReply.ACCEPT);
            levelFilter.setOnMismatch(FilterReply.DENY);

            SizeAndTimeBasedRollingPolicy rollingPolicy = new SizeAndTimeBasedRollingPolicy();
            rollingPolicy.setContext(context);
            rollingPolicy.setFileNamePattern("logs/error/error.%d{yyyy-MM-dd}_%i.log");
            rollingPolicy.setMaxFileSize(FileSize.valueOf("20MB"));
            rollingPolicy.setMaxHistory(30);
            rollingPolicy.setParent(rollingFileAppender);
            rollingPolicy.start();

            // context.getLogger("ERROR_LOGGER").setLevel(ch.qos.logback.classic.Level.DEBUG);
            context.getLogger("ERROR_LOGGER").addAppender(rollingFileAppender);
        }

        private void configureTraceFileLogging() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
            rollingFileAppender.setContext(context);
            rollingFileAppender.setName("TRACE_LOGGER");
            rollingFileAppender.setFile("logs/trace.log");

            LevelFilter levelFilter = new LevelFilter();
            levelFilter.setLevel(Level.TRACE);
            levelFilter.setOnMatch(FilterReply.ACCEPT);
            levelFilter.setOnMismatch(FilterReply.DENY);

            SizeAndTimeBasedRollingPolicy rollingPolicy = new SizeAndTimeBasedRollingPolicy();
            rollingPolicy.setContext(context);
            rollingPolicy.setFileNamePattern("logs/trace/trace.%d{yyyy-MM-dd}_%i.log");
            rollingPolicy.setMaxFileSize(FileSize.valueOf("20MB"));
            rollingPolicy.setMaxHistory(30);
            rollingPolicy.setParent(rollingFileAppender);
            rollingPolicy.start();

            // context.getLogger("TRACE_LOGGER").setLevel(ch.qos.logback.classic.Level.DEBUG);
            context.getLogger("TRACE_LOGGER").addAppender(rollingFileAppender);
        }

        private void configureDebugFileLogging() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
            rollingFileAppender.setContext(context);
            rollingFileAppender.setName("DEBUG_LOGGER");
            rollingFileAppender.setFile("logs/debug.log");

            LevelFilter levelFilter = new LevelFilter();
            levelFilter.setLevel(Level.DEBUG);
            levelFilter.setOnMatch(FilterReply.ACCEPT);
            levelFilter.setOnMismatch(FilterReply.DENY);

            SizeAndTimeBasedRollingPolicy rollingPolicy = new SizeAndTimeBasedRollingPolicy();
            rollingPolicy.setContext(context);
            rollingPolicy.setFileNamePattern("logs/debug/debug.%d{yyyy-MM-dd}_%i.log");
            rollingPolicy.setMaxFileSize(FileSize.valueOf("20MB"));
            rollingPolicy.setMaxHistory(30);
            rollingPolicy.setParent(rollingFileAppender);
            rollingPolicy.start();

            // context.getLogger("DEBUG_LOGGER").setLevel(ch.qos.logback.classic.Level.DEBUG);
            context.getLogger("DEBUG_LOGGER").addAppender(rollingFileAppender);
        }

        private void configureInfoFileLogging() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
            rollingFileAppender.setContext(context);
            rollingFileAppender.setName("INFO_LOGGER");
            rollingFileAppender.setFile("logs/info.log");

            LevelFilter levelFilter = new LevelFilter();
            levelFilter.setLevel(Level.INFO);
            levelFilter.setOnMatch(FilterReply.ACCEPT);
            levelFilter.setOnMismatch(FilterReply.DENY);

            SizeAndTimeBasedRollingPolicy rollingPolicy = new SizeAndTimeBasedRollingPolicy();
            rollingPolicy.setContext(context);
            rollingPolicy.setFileNamePattern("logs/info/info.%d{yyyy-MM-dd}_%i.log");
            rollingPolicy.setMaxFileSize(FileSize.valueOf("20MB"));
            rollingPolicy.setMaxHistory(30);
            rollingPolicy.setParent(rollingFileAppender);
            rollingPolicy.start();

            // context.getLogger("INFO_LOGGER").setLevel(ch.qos.logback.classic.Level.DEBUG);
            context.getLogger("INFO_LOGGER").addAppender(rollingFileAppender);
        }

        private void configureWarnFileLogging() {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
            rollingFileAppender.setContext(context);
            rollingFileAppender.setName("WARN_LOGGER");
            rollingFileAppender.setFile("logs/warn.log");

            LevelFilter levelFilter = new LevelFilter();
            levelFilter.setLevel(Level.WARN);
            levelFilter.setOnMatch(FilterReply.ACCEPT);
            levelFilter.setOnMismatch(FilterReply.DENY);

            SizeAndTimeBasedRollingPolicy rollingPolicy = new SizeAndTimeBasedRollingPolicy();
            rollingPolicy.setContext(context);
            rollingPolicy.setFileNamePattern("logs/warn/warn.%d{yyyy-MM-dd}_%i.log");
            rollingPolicy.setMaxFileSize(FileSize.valueOf("20MB"));
            rollingPolicy.setMaxHistory(30);
            rollingPolicy.setParent(rollingFileAppender);
            rollingPolicy.start();

            // context.getLogger("WARN_LOGGER").setLevel(ch.qos.logback.classic.Level.DEBUG);
            context.getLogger("WARN_LOGGER").addAppender(rollingFileAppender);
        }

    }

}
