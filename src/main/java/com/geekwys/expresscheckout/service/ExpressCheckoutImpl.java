package com.geekwys.expresscheckout.service;

import com.geekwys.expresscheckout.model.CheckoutRequest;
import com.geekwys.expresscheckout.model.CheckoutResponse;
import com.geekwys.expresscheckout.utils.Utility;
import com.google.gson.Gson;
import io.cellulant.service.CheckoutEncryption;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.geekwys.expresscheckout.model.Configs.*;

/**
 * @author Shem Mwangi
 */
@Slf4j
@Service("ExpressCheckoutImpl")
@AllArgsConstructor
public class ExpressCheckoutImpl implements ExpressCheckout {

    private static final Utility utility = new Utility();
    static String param;
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * prepare express checkout payload
     *
     * @JSON payload
     */
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
                .serviceCode(businessCode)
                .dueDate(utility.generateExpiryDate())
                .requestDescription("Not Narcotics")
                .countryCode("KEN")
                .languageCode("EN")
                .paymentOptionCode("Mpesa")
                .successRedirectUrl(webhookUrl)
                .failRedirectUrl(webhookUrl)
                .pendingRedirectUrl(webhookUrl)
                .callbackUrl(webhookUrl)
                .build();
    }

    /**
     * receive checkout payload for encryption
     *
     * @Encryption AES encryption
     */
    @Override
    public void encryptPayload() {
        //do encryption
        try {
            Gson gson = new Gson();
            CheckoutEncryption checkoutEncryption = new CheckoutEncryption(ivKey, secretKey);
            String jsonToString = gson.toJson(getCheckoutPayload());
            param = checkoutEncryption.encrypt(jsonToString);
        } catch (Exception e) {
            System.err.println("Thrown Exception " + e);
            e.printStackTrace();
        }
    }

    /**
     * make HTTP call to check out redirect
     *
     * @HTTP network call
     */
    @Override
    public void checkoutRedirect() {
        encryptPayload();
        String formulateUrl, encryptedPayload, redirectResponse;
        encryptedPayload = redirectUri.replace("|aesPayload|", param);
        formulateUrl = baseUri + encryptedPayload.replace("|accessKey|", accessKey);
        log.info("Formulated Checkout redirect URL: {}", formulateUrl);

        redirectResponse = restTemplate.getForObject(formulateUrl, String.class);
        //render to thymeleaf template
        log.info("Response from Redirect: {}", redirectResponse);
    }

    /**
     * receive callbacks after successful request
     * pending | successful | failed
     */
    @Override
    public void receiveCallback(CheckoutResponse checkoutResponse) {
        log.info("Checkout response status code: {}", checkoutResponse.getStatusCode());
    }
}
