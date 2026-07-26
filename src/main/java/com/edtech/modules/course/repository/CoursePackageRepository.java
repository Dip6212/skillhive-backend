package com.edtech.modules.course.repository;

import com.edtech.modules.course.entity.CoursePackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePackageRepository extends JpaRepository<CoursePackage, Long> {
}