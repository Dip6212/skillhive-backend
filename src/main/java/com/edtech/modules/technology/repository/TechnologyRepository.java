package com.edtech.modules.technology.repository;

import com.edtech.modules.technology.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    List<Technology> findByIsActiveTrueOrderByDisplayOrderAsc();
}