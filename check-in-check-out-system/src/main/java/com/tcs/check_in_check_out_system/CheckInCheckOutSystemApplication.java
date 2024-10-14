package com.tcs.check_in_check_out_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CheckInCheckOutSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckInCheckOutSystemApplication.class, args);
	}

}
