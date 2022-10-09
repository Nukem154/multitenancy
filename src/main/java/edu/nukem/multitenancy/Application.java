package edu.nukem.multitenancy;

import edu.nukem.multitenancy.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableConfigurationProperties(RsaKeyProperties.class)
@PropertySources(value = {
		@PropertySource("classpath:db/config/db-credentials.properties")
})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
