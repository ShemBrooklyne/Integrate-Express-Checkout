package com.geekwys.expresscheckout;

import com.geekwys.expresscheckout.model.Configs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ExpressCheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressCheckoutApplication.class, args);
		Configs configs = new Configs();
		String name = "%s %s %s".formatted(configs.getAccessKey(), configs.getIvKey(), configs.getSecretKey());
		log.info("This are my full names: {}", name);
	}

}
