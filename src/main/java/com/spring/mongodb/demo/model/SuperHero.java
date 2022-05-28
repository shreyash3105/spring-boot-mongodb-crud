package com.spring.mongodb.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "super_hero")
public class SuperHero implements Serializable {

	@Id
	private String id;
	private String name;
	private String superName;
    private String profession;
    private int age;
    private boolean canFly;
}
