<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>
                %-5level %logger{36} - %msg%n
            </Pattern>
        </layout>
    </appender>

    <!-- set DEBUG logging level for a package -->
    <logger name="com.my.package" level="debug">

    <!-- log warnings and errors by default -->
    <root level="warn">
        <appender-ref ref="STDOUT" />
    </root>

</configuration>