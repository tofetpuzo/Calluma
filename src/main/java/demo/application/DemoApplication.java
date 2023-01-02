package demo.application;

//import org.springframework.context.annotation.Configuration;
import demo.application.Repo.RoleRepo;
import demo.application.controller.UserResourceController;
import demo.application.service.UserService;
import demo.application.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;


//@Configuration

@EnableAutoConfiguration
@SpringBootApplication
@AutoConfigurationPackage
@ComponentScan(basePackageClasses = {UserResourceController.class, UserService.class, RoleRepo.class})
public class DemoApplication {
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
}
