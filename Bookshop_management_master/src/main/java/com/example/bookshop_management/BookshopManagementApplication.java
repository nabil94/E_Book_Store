package com.example.bookshop_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class BookshopManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopManagementApplication.class, args);
	}

	/**
	 * spring.datasource.url=jdbc:mysql://localhost:3306/bookshop_db
spring.datasource.username=root
spring.datasource.password=nabil094

spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE
	 */

}
