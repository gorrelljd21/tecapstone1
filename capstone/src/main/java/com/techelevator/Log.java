package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Log {

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dateInLog = date.format(formatter);


    public void writeToLog(String interactionType, BigDecimal interactionBalance, BigDecimal newBalance) {
        File transactionLog = new File("log.txt");
        try (FileOutputStream fos = new FileOutputStream(transactionLog, true); PrintWriter writer = new PrintWriter(fos)) {
            writer.printf("%s %s %s %s %n", dateInLog, interactionType, interactionBalance, newBalance);
        } catch (FileNotFoundException fnf) {
            System.out.println("This shouldn't happen.");
        } catch (IOException ioe){
            System.out.println("IO Error");
        }
    }
}

