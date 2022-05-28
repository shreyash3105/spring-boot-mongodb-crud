package com.spring.mongodb.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.spring.mongodb.demo.model.SuperHero;
import com.spring.mongodb.demo.repository.SuperHeroRepository;
import com.spring.mongodb.demo.utils.Utils;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongodbCrudApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbCrudApplication.class, args);
	}

	@Autowired
	private SuperHeroRepository superHeroRepository;
	
	@Bean
	CommandLineRunner runner () {
		return args -> {
			List<SuperHero> superHeroes = superHeroRepository.findAll();
			if (superHeroes.size() == 0) {
				LOGGER.info("******* Inserting Super heroes to DB *******");
				superHeroRepository.saveAll(Utils.superHeroesSupplier.get());
			} else {
				LOGGER.info("******* Super heroes stored in DB Size :: {}", superHeroes.size());
				LOGGER.info("******* Super heroes stored in DB :: {}", superHeroes);
			}
		};
	}
}
