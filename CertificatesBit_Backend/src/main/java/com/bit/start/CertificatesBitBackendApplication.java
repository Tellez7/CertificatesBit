package com.bit.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan (basePackages="com.bit.services,com.bit.repositories,com.bit.entities")
@EntityScan(basePackages = {"com.bit.entities"}) 
@EnableJpaRepositories ("com.bit.repositories")
public class CertificatesBitBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertificatesBitBackendApplication.class, args);
	}

}
