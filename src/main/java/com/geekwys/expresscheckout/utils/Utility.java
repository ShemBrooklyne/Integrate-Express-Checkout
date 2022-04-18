package com.geekwys.expresscheckout.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.geekwys.expresscheckout.model.Configs.clientCode;


/**
 * @author Shem Mwangi
 */
public class Utility {
    String randomStringID, randomString, dueDate;

    /**
     * generates random id's for transactions
     * used as merchantTransactionID in express-checkout requests'
     */
    public String generatePayerTransactionID() {
        randomStringID = String.valueOf(UUID.randomUUID()).toUpperCase();
        randomString = randomStringID.replace("-", "");
        return "%s%s".formatted(clientCode, randomString.substring(0, Math.min(randomString.length(), 8)));
    }

    /**
     * generates future dates for transactions (4 days ahead now's date)
     * used as due date in express-checkout requests'
     */
    public String generateExpiryDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate =  LocalDateTime.now();
        LocalDateTime futureDate = currentDate.plusDays(4);
        return dueDate = futureDate.format(dateTimeFormatter);
    }
}
