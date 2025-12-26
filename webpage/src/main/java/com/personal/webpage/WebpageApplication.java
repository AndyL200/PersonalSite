package com.personal.webpage;



import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.personal.webpage.User.UserData;


@SpringBootApplication
public class WebpageApplication {
		private static final Logger log = LoggerFactory.getLogger(WebpageApplication.class);
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(WebpageApplication.class, args);
		welcome w = context.getBean("welcome", welcome.class);
		System.out.println(w.getWelcomeMessage());
		log.info("Application Started Successfully");

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			UserData user = new UserData(1, "john_doe", "john_doe@email.com", java.time.LocalDateTime.now());
			log.info("User Data: " + user);
			log.info("CommandLineRunner executed");
		};
	}

}
