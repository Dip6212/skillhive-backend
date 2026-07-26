package com.edtech.modules.course.mapper;

import com.edtech.modules.course.dto.CourseDetailsResponse;
import com.edtech.modules.course.dto.CourseRequest;
import com.edtech.modules.course.dto.CourseResponse;
import com.edtech.modules.course.entity.Course;
import com.edtech.modules.course.entity.CoursePackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseRequest request);

    @Mapping(
            target = "packageName",
            expression = "java(getPackageName(course))"
    )
    CourseResponse toResponse(Course course);

    CourseDetailsResponse toDetailsResponse(Course course);

    default String getPackageName(Course course) {

        if (course.getPackages() == null || course.getPackages().isEmpty()) {
            return null;
        }

        for (CoursePackage pkg : course.getPackages()) {
            if (pkg.getName() != null) {
                return pkg.getName().name();
            }
        }

        return null;
    }
}