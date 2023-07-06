package com.sai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.sai"})
@Import(value = PersistenceConfig.class)
public class AppConfig {
	static {
		System.out.println("AppConfig.class file loaded");
	}
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
}
