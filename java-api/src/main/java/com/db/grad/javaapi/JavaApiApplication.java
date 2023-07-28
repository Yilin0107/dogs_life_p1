package com.db.grad.javaapi;

import com.db.grad.javaapi.model.Hero;
import com.db.grad.javaapi.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JavaApiApplication implements CommandLineRunner {
	@Autowired
	HeroRepository heroRepository;
	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}
    @Override
	public void run(String... args) throws Exception {
		List<Hero> heroes = heroRepository.findAll();
		for(Hero hero: heroes) {
			System.out.println(hero);
		}
	}
}
