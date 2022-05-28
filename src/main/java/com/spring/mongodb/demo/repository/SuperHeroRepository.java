package com.spring.mongodb.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.demo.model.SuperHero;

public interface SuperHeroRepository extends MongoRepository<SuperHero, String> {

}
