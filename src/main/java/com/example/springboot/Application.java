package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class Application{

	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;

	@Value("${host}")
	private String host;

	@Value("${databasename}")
	private String databasename;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			System.out.println("------------------------------------ ** BEAN NAMES ** -------------------------------------------------------");
			System.out.println("UserName : " + username);
			System.out.println("Password : " + password);
			System.out.println("Host : " + host);
			System.out.println("DatabaseName : " + databasename);

			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			System.out.println("------------------------------------ ** BEAN NAMES ** -------------------------------------------------------");

		};
	}

}
