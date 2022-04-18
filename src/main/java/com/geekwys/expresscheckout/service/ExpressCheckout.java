package com.geekwys.expresscheckout.service;

import com.geekwys.expresscheckout.model.CheckoutResponse;

/**
 * @author Shem Mwangi
 */
public interface ExpressCheckout {

    void encryptPayload();

    void checkoutRedirect();

    void receiveCallback(CheckoutResponse checkoutResponse);
}
