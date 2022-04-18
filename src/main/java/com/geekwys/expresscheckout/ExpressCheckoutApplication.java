package com.geekwys.expresscheckout;

import com.geekwys.expresscheckout.model.Configs;
import com.geekwys.expresscheckout.service.ExpressCheckoutImpl;
import com.geekwys.expresscheckout.utils.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ExpressCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressCheckoutApplication.class, args);
		ExpressCheckoutImpl expressCheckout = new ExpressCheckoutImpl();
		expressCheckout.encryptPayload();
	}

}
