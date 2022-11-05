package com.pc3v.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Pok_back {

	public static void main(String[] args) {
    SpringApplication.run(Pok_back.class, args);
	}

}
