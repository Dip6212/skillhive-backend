package com.edtech.modules.technology.mapper;

import com.edtech.modules.technology.dto.TechnologyRequest;
import com.edtech.modules.technology.dto.TechnologyResponse;
import com.edtech.modules.technology.entity.Technology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    Technology toEntity(TechnologyRequest request);

    TechnologyResponse toResponse(Technology technology);
}