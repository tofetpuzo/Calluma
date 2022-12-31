package demo.application.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Configuration
@ComponentScan(basePackages = "demo.application.demo.controller" + "demo.application.service"+ 
                              "demo.application.domain"+ "demo.application.Repo")
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
	    SpringApplication.run(DemoApplication.class, args);
	}

}
