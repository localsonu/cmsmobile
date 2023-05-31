package com.cmsmobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CmsmobileApplication {
    public static void main(String[] args) {
		try {
		SpringApplication.run(CmsmobileApplication.class, args);
	}
		catch (Throwable throwable)
		{
			System.out.println(throwable.toString());
			throwable.printStackTrace();
		}
	}
}