package com.edtech.modules.course.service;

import com.edtech.common.exception.BadRequestException;
import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.course.dto.*;
import com.edtech.modules.course.entity.Course;
import com.edtech.modules.course.entity.CourseModule;
import com.edtech.modules.course.entity.CoursePackage;
import com.edtech.modules.course.mapper.CourseMapper;
import com.edtech.modules.course.repository.CourseModuleRepository;
import com.edtech.modules.course.repository.CoursePackageRepository;
import com.edtech.modules.course.repository.CoursePackageRepository;
import com.edtech.modules.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    private final CoursePackageRepository coursePackageRepository;

    private final CourseModuleRepository moduleRepository;

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository
                .findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public CourseResponse getCourseBySlug(String slug) {

        Course course = courseRepository.findBySlug(slug)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found"
                        )
                );

        return courseMapper.toResponse(course);
    }

    @Override
    public CourseResponse createCourse(CourseRequest request) {

        if (courseRepository.existsBySlug(request.getSlug())) {
            throw new BadRequestException("Course slug already exists");
        }

        Course course = courseMapper.toEntity(request);

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toResponse(savedCourse);
    }

    @Override
    public PackageResponse createPackage(
            Long courseId,
            PackageRequest request
    ) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found")
                );

        CoursePackage coursePackage = CoursePackage.builder()
                .name(request.getName())
                .course(course)
                .build();

        coursePackageRepository.save(coursePackage);

        return PackageResponse.builder()
                .id(coursePackage.getId())
                .name(coursePackage.getName())
                .modules(List.of())
                .build();
    }

    @Override
    public ModuleResponse createModule(
            Long packageId,
            ModuleRequest request
    ) {

        CoursePackage coursePackage = coursePackageRepository.findById(packageId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Package not found")
                );

        CourseModule module = CourseModule.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .displayOrder(request.getDisplayOrder())
                .coursePackage(coursePackage)
                .build();

        moduleRepository.save(module);

        return ModuleResponse.builder()
                .id(module.getId())
                .title(module.getTitle())
                .description(module.getDescription())
                .duration(module.getDuration())
                .displayOrder(module.getDisplayOrder())
                .build();
    }

    @Override
    public CourseResponse updateCourse(
            Long id,
            CourseRequest request
    ) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found")
                );

        if (!course.getSlug().equals(request.getSlug())
                && courseRepository.existsBySlug(request.getSlug())) {
            throw new BadRequestException("Course slug already exists");
        }

        course.setTitle(request.getTitle());
        course.setSlug(request.getSlug());
        course.setShortDescription(request.getShortDescription());
        course.setDescription(request.getDescription());
        course.setDuration(request.getDuration());
        course.setLevel(request.getLevel());
        course.setMode(request.getMode());
        course.setRating(request.getRating());
        course.setStudents(request.getStudents());
        course.setImageUrl(request.getImageUrl());
        course.setBrochureUrl(request.getBrochureUrl());
        course.setFeatured(request.getFeatured());

        Course updatedCourse = courseRepository.save(course);

        return courseMapper.toResponse(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found")
                );

        courseRepository.delete(course);
    }

    @Override
    public PackageResponse getPackageById(Long id) {

        CoursePackage coursePackage = coursePackageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Package not found")
                );

        return mapPackage(coursePackage);
    }

    @Override
    public PackageResponse updatePackage(
            Long id,
            PackageRequest request
    ) {

        CoursePackage coursePackage = coursePackageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Package not found")
                );

        coursePackage.setName(request.getName());

        CoursePackage updatedPackage =
                coursePackageRepository.save(coursePackage);

        return mapPackage(updatedPackage);
    }

    @Override
    public void deletePackage(Long id) {

        CoursePackage coursePackage = coursePackageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Package not found")
                );

        coursePackageRepository.delete(coursePackage);
    }
    private List<ModuleResponse> mapModules(List<CourseModule> modules) {

        if (modules == null || modules.isEmpty()) {
            return List.of();
        }

        return modules.stream()
                .map(module -> ModuleResponse.builder()
                        .id(module.getId())
                        .title(module.getTitle())
                        .description(module.getDescription())
                        .duration(module.getDuration())
                        .displayOrder(module.getDisplayOrder())
                        .build())
                .toList();
    }
    private PackageResponse mapPackage(CoursePackage coursePackage) {

        return PackageResponse.builder()
                .id(coursePackage.getId())
                .name(coursePackage.getName())
                .modules(mapModules(coursePackage.getModules()))
                .build();
    }


    @Override
    public ModuleResponse getModuleById(Long id) {

        CourseModule module = moduleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Module not found")
                );

        return ModuleResponse.builder()
                .id(module.getId())
                .title(module.getTitle())
                .description(module.getDescription())
                .duration(module.getDuration())
                .displayOrder(module.getDisplayOrder())
                .build();
    }

    @Override
    public ModuleResponse updateModule(
            Long id,
            ModuleRequest request
    ) {

        CourseModule module = moduleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Module not found")
                );

        module.setTitle(request.getTitle());
        module.setDescription(request.getDescription());
        module.setDuration(request.getDuration());
        module.setDisplayOrder(request.getDisplayOrder());

        CourseModule updatedModule = moduleRepository.save(module);

        return ModuleResponse.builder()
                .id(updatedModule.getId())
                .title(updatedModule.getTitle())
                .description(updatedModule.getDescription())
                .duration(updatedModule.getDuration())
                .displayOrder(updatedModule.getDisplayOrder())
                .build();
    }

    @Override
    public void deleteModule(Long id) {

        CourseModule module = moduleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Module not found")
                );

        moduleRepository.delete(module);
    }

    @Override
    public CourseDetailsResponse getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        return CourseDetailsResponse.builder()

                .id(course.getId())
                .title(course.getTitle())
                .slug(course.getSlug())
                .shortDescription(course.getShortDescription())
                .description(course.getDescription())
                .duration(course.getDuration())
                .level(course.getLevel())
                .mode(course.getMode())
                .rating(course.getRating())
                .students(course.getStudents())
                .imageUrl(course.getImageUrl())
                .brochureUrl(course.getBrochureUrl())
                .featured(course.getFeatured())

                .packages(
                        course.getPackages()
                                .stream()
                                .map(this::mapPackage)
                                .toList()
                )

                .build();
    }

    @Override
    public CourseDetailsResponse getCourseDetailsBySlug(String slug) {

        Course course = courseRepository.findBySlug(slug)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found")
                );

        return CourseDetailsResponse.builder()
                .id(course.getId())
                .title(course.getTitle())
                .slug(course.getSlug())
                .shortDescription(course.getShortDescription())
                .description(course.getDescription())
                .duration(course.getDuration())
                .level(course.getLevel())
                .mode(course.getMode())
                .rating(course.getRating())
                .students(course.getStudents())
                .imageUrl(course.getImageUrl())
                .brochureUrl(course.getBrochureUrl())
                .featured(course.getFeatured())
                .packages(
                        course.getPackages()
                                .stream()
                                .map(this::mapPackage)
                                .toList()
                )
                .build();
    }


}