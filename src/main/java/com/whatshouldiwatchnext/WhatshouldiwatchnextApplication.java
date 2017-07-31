package com.whatshouldiwatchnext;

import com.whatshouldiwatchnext.Entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class WhatshouldiwatchnextApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatshouldiwatchnextApplication.class, args);
	}
}
