package com.spring.mongodb.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.spring.mongodb.demo.model.SuperHero;

public class Utils {
	
	private Utils() {
		
	}

	public static Supplier<List<SuperHero>> superHeroesSupplier = () ->
		Arrays.asList(
                SuperHero.builder().name("Wade").superName("Deadpool").profession("Street fighter").age(28).canFly(false).build(),
                SuperHero.builder().name("Bruce").superName("Hulk").profession("Doctor").age(50).canFly(false).build(),
                SuperHero.builder().name("Steve").superName("Captain America").profession("Solder").age(120).canFly(false).build(),
                SuperHero.builder().name("Tony").superName("Iron Man").profession("Business man").age(45).canFly(true).build(),
                SuperHero.builder().name("Peter").superName("Spider Man").profession("Student").age(21).canFly(true).build()
        );
}
