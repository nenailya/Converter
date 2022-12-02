package com.example.converter;

import com.example.converter.interfaces.Converter;
import com.example.converter.interfaces.impl.ConverterImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);
	}

	@Bean
	public Converter converter() {
		return new ConverterImpl();
	}
}
