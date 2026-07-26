package com.edtech.modules.course.repository;

import com.edtech.modules.course.entity.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseModuleRepository extends JpaRepository<CourseModule, Long> {
}