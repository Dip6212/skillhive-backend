package com.edtech.modules.course.mapper;

import com.edtech.modules.course.dto.ModuleResponse;
import com.edtech.modules.course.entity.CourseModule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseModuleMapper {

    ModuleResponse toResponse(CourseModule module);

}