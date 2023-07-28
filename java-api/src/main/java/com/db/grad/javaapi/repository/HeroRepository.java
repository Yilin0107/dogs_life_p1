package com.db.grad.javaapi.repository;
import com.db.grad.javaapi.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository <Hero, Integer> {

}
