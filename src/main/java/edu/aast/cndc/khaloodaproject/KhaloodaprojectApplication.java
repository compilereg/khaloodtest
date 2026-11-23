package edu.aast.cndc.khaloodaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"edu.aast.cndc.controller","edu.aast.cndc.config"})
public class KhaloodaprojectApplication {
 
	public static void main(String[] args) {
		System.out.println("Starting...");
		SpringApplication.run(KhaloodaprojectApplication.class, args);
	}

}
