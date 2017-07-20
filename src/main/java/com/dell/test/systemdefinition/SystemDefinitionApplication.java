package com.dell.test.systemdefinition;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SystemDefinitionApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SystemDefinitionApplication.class, args);
	}

	@Bean
	public Database mydb(CloudantClient couchdbClient) {
		return couchdbClient.database("systemdefinition", true);
	}
}
