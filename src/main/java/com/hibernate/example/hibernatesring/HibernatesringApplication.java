package com.hibernate.example.hibernatesring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class HibernatesringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatesringApplication.class, args);
    }

}
