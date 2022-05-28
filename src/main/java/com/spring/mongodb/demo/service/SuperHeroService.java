package com.spring.mongodb.demo.service;

import java.util.List;

import com.spring.mongodb.demo.model.SuperHero;

public interface SuperHeroService {
	
	List<?> findAll();
	
	SuperHero findById(String id);
	
	SuperHero save(SuperHero superHero);

    SuperHero update(SuperHero superHero);

    void delete(String id);

}
