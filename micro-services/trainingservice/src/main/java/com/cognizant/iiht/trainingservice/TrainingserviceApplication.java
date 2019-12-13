package com.cognizant.iiht.trainingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TrainingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingserviceApplication.class, args);
	}

}
