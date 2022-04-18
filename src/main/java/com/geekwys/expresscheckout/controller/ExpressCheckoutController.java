package com.geekwys.expresscheckout.controller;

import com.geekwys.expresscheckout.model.CheckoutResponse;
import com.geekwys.expresscheckout.service.ExpressCheckoutImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shem Mwangi
 */
@RestController
@RequestMapping(path = "/")
public class ExpressCheckoutController {

    private final ExpressCheckoutImpl expressCheckoutImpl;

    public ExpressCheckoutController(ExpressCheckoutImpl expressCheckoutImpl) {
        this.expressCheckoutImpl = expressCheckoutImpl;
    }

    @PostMapping("/receiveCallbacks")
    public void acknowledgeRequestStatus(@RequestBody CheckoutResponse checkoutResponse) {
        expressCheckoutImpl.receiveCallback(checkoutResponse);
    }
}
