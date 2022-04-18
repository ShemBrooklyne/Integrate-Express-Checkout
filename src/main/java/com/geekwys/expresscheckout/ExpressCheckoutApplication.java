package com.geekwys.expresscheckout;

import com.geekwys.expresscheckout.service.ExpressCheckoutImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class ExpressCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressCheckoutApplication.class, args);
		ExpressCheckoutImpl expressCheckout = new ExpressCheckoutImpl();
		expressCheckout.checkoutRedirect();
	}
}
