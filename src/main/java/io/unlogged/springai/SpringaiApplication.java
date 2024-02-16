package io.unlogged.springai;

import io.unlogged.Unlogged;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringaiApplication {

	@Unlogged
	public static void main(String[] args) {
		SpringApplication.run(SpringaiApplication.class, args);
	}

}
