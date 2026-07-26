package com.edtech.modules.course.service;

import com.edtech.modules.course.dto.*;

import java.util.List;

public interface CourseService {

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseBySlug(String slug);

    CourseResponse createCourse(CourseRequest request);

    PackageResponse createPackage(
            Long courseId,
            PackageRequest request
    );

    ModuleResponse createModule(
            Long packageId,
            ModuleRequest request
    );

    CourseResponse updateCourse(
            Long id,
            CourseRequest request
    );

    void deleteCourse(Long id);

    PackageResponse getPackageById(Long id);

    PackageResponse updatePackage(
            Long id,
            PackageRequest request
    );

    void deletePackage(Long id);


    ModuleResponse getModuleById(Long id);

    ModuleResponse updateModule(
            Long id,
            ModuleRequest request
    );

    void deleteModule(Long id);

    CourseDetailsResponse getCourseById(Long id);

    CourseDetailsResponse getCourseDetailsBySlug(String slug);

}