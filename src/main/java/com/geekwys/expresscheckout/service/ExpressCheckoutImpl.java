package com.geekwys.expresscheckout.service;

import com.geekwys.expresscheckout.model.CheckoutRequest;
import com.geekwys.expresscheckout.utils.Utility;
import com.google.gson.Gson;
import io.cellulant.service.CheckoutEncryption;
import lombok.extern.slf4j.Slf4j;

import static com.geekwys.expresscheckout.model.Configs.ivKey;
import static com.geekwys.expresscheckout.model.Configs.secretKey;

@Slf4j
public class ExpressCheckoutImpl {

    public static Utility utility = new Utility();

    /**
     * prepare express checkout payload
     *
     * @JSON payload
     **/
    public static CheckoutRequest getCheckoutPayload() {
        return CheckoutRequest.builder()
                .merchantTransactionId(utility.generatePayerTransactionID())
                .customerFirstName("Shem")
                .customerLastName("Mwangi")
                .msisdn("254721863288")
                .customerEmail("shemnyatti@gmail.com")
                .requestAmount("10.00")
                .currencyCode("KES")
                .accountNumber("254721863288")
                .serviceCode("DEMOSERVICE")
                .dueDate(utility.generateExpiryDate())
                .requestDescription("Not narcotics")
                .countryCode("KEN")
                .languageCode("EN")
                .paymentOptionCode("Mpesa")
                .successRedirectUrl("/success")
                .failRedirectUrl("/failed")
                .pendingRedirectUrl("/pending")
                .callbackUrl("/callback")
                .build();
    }

    /**
     * receive checkout payload for encryption
     *
     * @Encryption AES encryption
     */
    public void encryptPayload() {
        //do encryption
        try {
            Gson gson = new Gson();
            CheckoutEncryption checkoutEncryption = new CheckoutEncryption(ivKey, secretKey);
            String jsonToString = gson.toJson(getCheckoutPayload());
            String param = checkoutEncryption.encrypt(jsonToString);
            log.debug("Encrypted Payload={}", param);
        } catch (Exception e) {
            System.err.println("Thrown Exception " + e);
            e.printStackTrace();
        }
    }
}
