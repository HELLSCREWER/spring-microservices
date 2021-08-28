package com.microservice.springCloudConfigServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigurationServer {

	@Value("${limits-service.maximum}")
	static String cloudVar;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigurationServer.class, args);
		System.out.println("*****************************************************"+cloudVar);
	}
}
