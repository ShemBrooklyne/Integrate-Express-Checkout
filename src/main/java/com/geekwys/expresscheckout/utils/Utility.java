package com.geekwys.expresscheckout.utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import static com.geekwys.expresscheckout.model.Configs.clientCode;


/**
 * @author Shem Mwangi
 **/
public class Utility {
    String randomStringID, randomString, dueDate;

    /**
     * generates random id's for transactions
     * used as merchantTransactionID in postPayments'
     **/
    public String generatePayerTransactionID() {
        randomStringID = String.valueOf(UUID.randomUUID()).toUpperCase();
        randomString = randomStringID.replace("-", "");
        return "%s%s".formatted(clientCode, randomString.substring(0, Math.min(randomString.length(), 8)));
    }

    public String generateExpiryDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate =  LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(4);
        return dueDate = futureDate.format(dateTimeFormatter);
    }
}
