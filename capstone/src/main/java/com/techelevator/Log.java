package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Log {

    private String interactionType;
    private BigDecimal interactionBalance = new BigDecimal("0.00");
    private BigDecimal newBalance = new BigDecimal("0.00");

    public String getInteractionType() {
        return interactionType;
    }

    public BigDecimal getInteractionBalance() {
        return interactionBalance;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dateInLog = date.format(formatter);
//
//    File transactionLog = new File("log.txt");

    public void writeToLog() {
        try {
            File transactionLog = new File("log.txt");
            FileOutputStream fos = new FileOutputStream("log.txt", true);
            PrintWriter writer = new PrintWriter(fos);
            writer.printf("%s %s %s %s \n", dateInLog, this.interactionType, this.interactionBalance, this.newBalance);
            writer.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("This shouldn't happen.");
        }

    }
}

