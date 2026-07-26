package com.edtech.modules.course.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.course.dto.*;
import com.edtech.modules.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/public/courses")
    public ApiResponse<List<CourseResponse>> getAllCourses() {

        return ApiResponse.<List<CourseResponse>>builder()
                .success(true)
                .message("Courses fetched successfully")
                .data(courseService.getAllCourses())
                .build();
    }

    @GetMapping("/admin/courses")
    public ApiResponse<List<CourseResponse>> getAllAdminCourses() {

        return ApiResponse.<List<CourseResponse>>builder()
                .success(true)
                .message("Courses fetched successfully")
                .data(courseService.getAllCourses())
                .build();
    }



    @GetMapping("/public/courses/{slug}")
    public ApiResponse<CourseDetailsResponse> getCourseBySlug(
            @PathVariable String slug
    ) {

        return ApiResponse.<CourseDetailsResponse>builder()
                .success(true)
                .message("Course fetched successfully")
                .data(courseService.getCourseDetailsBySlug(slug))
                .build();
    }
    // need to make it admin
    @PostMapping("/admin/courses")
    public ApiResponse<CourseResponse> createCourse(
            @Valid @RequestBody CourseRequest request
    ) {
            System.out.println("Inside createCourse");

        return ApiResponse.<CourseResponse>builder()
                .success(true)
                .message("Course created successfully")
                .data(courseService.createCourse(request))
                .build();
    }

    @PostMapping("/admin/courses/{courseId}/packages")
    public ApiResponse<PackageResponse> createPackage(
            @PathVariable Long courseId,
            @Valid @RequestBody PackageRequest request
    ) {

        return ApiResponse.<PackageResponse>builder()
                .success(true)
                .message("Package created successfully")
                .data(courseService.createPackage(courseId, request))
                .build();
    }

    @PostMapping("/admin/packages/{packageId}/modules")
    public ApiResponse<ModuleResponse> createModule(
            @PathVariable Long packageId,
            @Valid @RequestBody ModuleRequest request
    ) {

        return ApiResponse.<ModuleResponse>builder()
                .success(true)
                .message("Module created successfully")
                .data(courseService.createModule(packageId, request))
                .build();
    }

    @PutMapping("/admin/courses/{id}")
    public ApiResponse<CourseResponse> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequest request
    ) {

        return ApiResponse.<CourseResponse>builder()
                .success(true)
                .message("Course updated successfully")
                .data(courseService.updateCourse(id, request))
                .build();
    }

    @DeleteMapping("/admin/courses/{id}")
    public ApiResponse<Void> deleteCourse(
            @PathVariable Long id
    ) {

        courseService.deleteCourse(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Course deleted successfully")
                .build();
    }

    @GetMapping("/public/packages/{id}")
    public ApiResponse<PackageResponse> getPackage(
            @PathVariable Long id
    ) {

        return ApiResponse.<PackageResponse>builder()
                .success(true)
                .message("Package fetched successfully")
                .data(courseService.getPackageById(id))
                .build();
    }

    @PutMapping("/admin/packages/{id}")
    public ApiResponse<PackageResponse> updatePackage(
            @PathVariable Long id,
            @Valid @RequestBody PackageRequest request
    ) {

        return ApiResponse.<PackageResponse>builder()
                .success(true)
                .message("Package updated successfully")
                .data(courseService.updatePackage(id, request))
                .build();
    }

    @DeleteMapping("/admin/packages/{id}")
    public ApiResponse<Void> deletePackage(
            @PathVariable Long id
    ) {

        courseService.deletePackage(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Package deleted successfully")
                .build();
    }

    @GetMapping("/public/modules/{id}")
    public ApiResponse<ModuleResponse> getModule(
            @PathVariable Long id
    ) {

        return ApiResponse.<ModuleResponse>builder()
                .success(true)
                .message("Module fetched successfully")
                .data(courseService.getModuleById(id))
                .build();
    }

    @PutMapping("/admin/modules/{id}")
    public ApiResponse<ModuleResponse> updateModule(
            @PathVariable Long id,
            @Valid @RequestBody ModuleRequest request
    ) {

        return ApiResponse.<ModuleResponse>builder()
                .success(true)
                .message("Module updated successfully")
                .data(courseService.updateModule(id, request))
                .build();
    }
    @DeleteMapping("/admin/modules/{id}")
    public ApiResponse<Void> deleteModule(
            @PathVariable Long id
    ) {

        courseService.deleteModule(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Module deleted successfully")
                .build();
    }

    @GetMapping("/admin/courses/{id}")
    public ApiResponse<CourseDetailsResponse> getCourseById(
            @PathVariable Long id
    ) {

        return ApiResponse.<CourseDetailsResponse>builder()
                .success(true)
                .message("Course fetched successfully")
                .data(courseService.getCourseById(id))
                .build();
    }



}