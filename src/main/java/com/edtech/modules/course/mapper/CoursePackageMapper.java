package com.edtech.modules.course.mapper;

import com.edtech.modules.course.dto.PackageResponse;
import com.edtech.modules.course.entity.CoursePackage;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = CourseModuleMapper.class
)
public interface CoursePackageMapper {

    PackageResponse toResponse(CoursePackage entity);

}