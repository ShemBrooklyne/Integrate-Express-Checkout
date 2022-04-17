package com.geekwys.expresscheckout.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payload {
    private String merchantTransactionID;
    private String customerFirstName;
    private String customerLastName;
    private String MSISDN;
    private String customerEmail;
    private String requestAmount;
    private String currencyCode;
    private String accountNumber;
    private String serviceCode;
    private String dueDate;
    private String requestDescription;
    private String countryCode;
    private String languageCode;
    private String payerClientCode;
    private String successRedirectUrl;
    private String failRedirectUrl;
    private String pendingRedirectUrl;
    private String paymentWebhookUrl;
}
