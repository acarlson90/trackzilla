package com.aaroncarlson;

import com.aaroncarlson.model.Application;
import com.aaroncarlson.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrackzillaApplication {

	private static final Logger log = LoggerFactory.getLogger(TrackzillaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrackzillaApplication.class, args);
	}

	@Bean
	public CommandLineRunner poulateApplicationDatabase(ApplicationRepository repository) {
		return (args) -> {
			repository.save(new Application("Football", "aaron.carlson", "Application for Fantasy Football"));
			repository.save(new Application("Baseball", "aaron.carlson", "Application for Fantasy Baseball"));
			repository.save(new Application("Basketball", "aaron.carlson", "Application for Fantasy Basketball"));

			for (Application application : repository.findAll()) {
				log.info(application.toString());
			}
		};
	}

}
