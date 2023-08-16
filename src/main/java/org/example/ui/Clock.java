package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Clock extends JFrame {
    private final JLabel clockLabel=new JLabel();

    Clock(){

        clockLabel.setFont(new Font("Fira Code",Font.BOLD,18));
        clockLabel.setForeground(Color.GREEN);

        JPanel clockPanel = new JPanel();
        clockPanel.setBackground(Color.black);
        clockPanel.add(clockLabel);

        add(clockPanel);

        setSize(400,200);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Thread clockThread = new Thread(()->{
            while(true){
                ZonedDateTime dateTime=ZonedDateTime.now();
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm:ss a dd/MM/yyyy z");
                clockLabel.setText(formatter.format(dateTime));

                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        clockThread.setName("Clock Thread");
        clockThread.start();
    }
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.setTitle("Clock");
        clock.setVisible(true);
    }
}
