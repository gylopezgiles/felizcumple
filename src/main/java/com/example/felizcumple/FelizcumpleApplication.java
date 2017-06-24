package com.example.felizcumple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FelizcumpleApplication implements CommandLineRunner{

	@Autowired
    EnvironmentConfig dataInicilizator;
	
	public static void main(String[] args) {
		SpringApplication.run(FelizcumpleApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		dataInicilizator.generateInitialData();
		
	}
}
