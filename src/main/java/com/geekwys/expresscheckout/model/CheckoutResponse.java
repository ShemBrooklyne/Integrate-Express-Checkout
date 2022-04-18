package com.geekwys.expresscheckout.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shem Mwangi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutResponse {
    @SerializedName("checkout_request_id")
    @Expose
    public Integer checkoutRequestId;
    @SerializedName("merchant_transaction_id")
    @Expose
    public String merchantTransactionId;
    @SerializedName("status_code")
    @Expose
    public String statusCode;
    @SerializedName("status_description")
    @Expose
    public String statusDescription;
    @SerializedName("receipt_number")
    @Expose
    public String receiptNumber;
}
