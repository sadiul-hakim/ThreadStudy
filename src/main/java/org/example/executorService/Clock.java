package org.example.executorService;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(
                Clock::printTime,
                0,
                1,
                TimeUnit.SECONDS
        );

    }

    public static void printTime(){
        ZonedDateTime dateTime=ZonedDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm:ss a dd/MM/yyyy z");
        System.out.println(formatter.format(dateTime));
    }
}
