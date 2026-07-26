package com.edtech.modules.hero.repository;

import com.edtech.modules.hero.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    Optional<Hero> findByIsActiveTrue();

    boolean existsByIsActiveTrue();
}