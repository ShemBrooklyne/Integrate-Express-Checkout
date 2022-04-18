package com.geekwys.expresscheckout.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutRequest {

    @SerializedName("msisdn")
    @Expose
    public String msisdn;
    @SerializedName("account_number")
    @Expose
    public String accountNumber;
    @SerializedName("country_code")
    @Expose
    public String countryCode;
    @SerializedName("currency_code")
    @Expose
    public String currencyCode;
    @SerializedName("customer_email")
    @Expose
    public String customerEmail;
    @SerializedName("customer_first_name")
    @Expose
    public String customerFirstName;
    @SerializedName("customer_last_name")
    @Expose
    public String customerLastName;
    @SerializedName("due_date")
    @Expose
    public String dueDate;
    @SerializedName("fail_redirect_url")
    @Expose
    public String failRedirectUrl;
    @SerializedName("merchant_transaction_id")
    @Expose
    public String merchantTransactionId;
    @SerializedName("payment_option_code")
    @Expose
    public String paymentOptionCode;
    @SerializedName("callback_url")
    @Expose
    public String callbackUrl;
    @SerializedName("pending_redirect_url")
    @Expose
    public String pendingRedirectUrl;
    @SerializedName("request_amount")
    @Expose
    public String requestAmount;
    @SerializedName("request_description")
    @Expose
    public String requestDescription;
    @SerializedName("success_redirect_url")
    @Expose
    public String successRedirectUrl;
    @SerializedName("invoice_number")
    @Expose
    public String invoiceNumber;
    @SerializedName("language_code")
    @Expose
    public String languageCode;
    @SerializedName("is_offline")
    @Expose
    public String isOffline;
    @SerializedName("service_code")
    @Expose
    public String serviceCode;
    @SerializedName("access_key")
    @Expose
    public String accessKey;
    @SerializedName("iv_key")
    @Expose
    public String ivKey;
    @SerializedName("secret_key")
    @Expose
    public String secretKey;
    @SerializedName("charge_beneficiaries")
    @Expose
    public List<ChargeBeneficiary> chargeBeneficiaries = null;

    static class ChargeBeneficiary {
        @SerializedName("charge_beneficiary_code")
        @Expose
        public String chargeBeneficiaryCode;
        @SerializedName("amount")
        @Expose
        public Integer amount;

    }

}


