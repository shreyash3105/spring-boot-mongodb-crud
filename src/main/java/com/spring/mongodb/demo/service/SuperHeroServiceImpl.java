package com.spring.mongodb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongodb.demo.model.SuperHero;
import com.spring.mongodb.demo.repository.SuperHeroRepository;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
	
	@Autowired
	private SuperHeroRepository repository;

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public SuperHero findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(new SuperHero());
	}

	@Override
	public SuperHero save(SuperHero superHero) {
		// TODO Auto-generated method stub
		return repository.save(superHero);
	}

	@Override
	public SuperHero update(SuperHero superHero) {
		// TODO Auto-generated method stub
		return repository.save(superHero);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.findById(id).ifPresent(superhero -> repository.delete(superhero));
	}

}
